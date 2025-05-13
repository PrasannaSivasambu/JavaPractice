

// -------- application.properties --------
aws.region=ap-south-1
aws.s3.bucket-name=your-bucket-name

// -------- Product.java (Entity) --------
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> imageUrls = new ArrayList<>();

    // Getters and setters
}

// -------- ProductRepository.java --------
public interface ProductRepository extends JpaRepository<Product, Long> {}

// -------- ProductResponse.java (DTO) --------
public class ProductResponse {
    private Long id;
    private String name;
    private List<String> imageUrls;

    public ProductResponse(Long id, String name, List<String> imageUrls) {
        this.id = id;
        this.name = name;
        this.imageUrls = imageUrls;
    }

    // Getters and setters
}

// -------- S3Config.java --------
@Configuration
public class S3Config {

    @Value("${aws.region}")
    private String region;

    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }
}

// -------- S3FileStorageService.java --------
@Service
public class S3FileStorageService {

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    private final S3Client s3Client;

    @Autowired
    public S3FileStorageService(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadImage(MultipartFile file) {
        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        try {
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(filename)
                    .contentType(file.getContentType())
                    .acl(ObjectCannedACL.PUBLIC_READ)
                    .build();

            s3Client.putObject(request, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
            return generateS3Url(filename);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file to S3", e);
        }
    }

    public byte[] downloadImage(String key) {
        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        try (ResponseInputStream<GetObjectResponse> inputStream = s3Client.getObject(request)) {
            return inputStream.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException("Failed to download file from S3", e);
        }
    }

    public void deleteImage(String key) {
        DeleteObjectRequest request = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
        s3Client.deleteObject(request);
    }

    public String generateS3Url(String key) {
        return String.format("https://%s.s3.amazonaws.com/%s", bucketName, key);
    }

    public String extractKeyFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }
}

// -------- ProductService.java --------
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private S3FileStorageService s3FileStorageService;

    public void addProductImage(Long productId, MultipartFile file) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        String imageUrl = s3FileStorageService.uploadImage(file);
        product.getImageUrls().add(imageUrl);
        productRepository.save(product);
    }

    public void deleteProductImage(Long productId, String imageUrl) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getImageUrls().remove(imageUrl)) {
            String key = s3FileStorageService.extractKeyFromUrl(imageUrl);
            s3FileStorageService.deleteImage(key);
            productRepository.save(product);
        } else {
            throw new RuntimeException("Image URL not found in product");
        }
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> productResponses = new ArrayList<>();

        // Iterate through all products
        for (Product product : productRepository.findAll()) {
            List<byte[]> images = new ArrayList<>();

            // For each image URL, download the corresponding image from S3
            for (String imageUrl : product.getImageUrls()) {
                String key = s3FileStorageService.extractKeyFromUrl(imageUrl);
                byte[] imageBytes = s3FileStorageService.downloadImage(key);
                images.add(imageBytes);
            }

            // Create a ProductResponse with the images as byte arrays
            ProductResponse response = new ProductResponse(
                product.getId(),
                product.getName(),
                product.getImageUrls(),
                images
            );

            productResponses.add(response);
        }

        return productResponses;
    }
}

// -------- ProductController.java --------
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private S3FileStorageService s3FileStorageService;

    @PutMapping("/{productId}/image")
    public ResponseEntity<String> uploadImage(@PathVariable Long productId,
                                              @RequestParam("image") MultipartFile imageFile) {
        productService.addProductImage(productId, imageFile);
        return ResponseEntity.ok("Image uploaded successfully.");
    }

    @DeleteMapping("/{productId}/image")
    public ResponseEntity<String> deleteImage(@PathVariable Long productId,
                                              @RequestParam("imageUrl") String imageUrl) {
        productService.deleteProductImage(productId, imageUrl);
        return ResponseEntity.ok("Image deleted successfully.");
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadImage(@RequestParam String key) {
        byte[] imageBytes = s3FileStorageService.downloadImage(key);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + key)
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageBytes);
    }
}

public class S3ClientImageUploadDownload {
    
}
