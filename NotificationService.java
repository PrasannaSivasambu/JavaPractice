import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        // Save the product (assuming saveProduct method exists)
        productService.addProduct(product);

        // Send email notification after product is added
        notificationService.sendProductAddedNotification("user@example.com", product.getName());
        
        return ResponseEntity.ok("Product added and notification sent.");
    }
}



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private EmailService emailService;

    public void sendProductAddedNotification(String userEmail, String productName) {
        String subject = "New Product Added!";
        String text = "Dear user,\n\nA new product named " + productName + " has been added to the store.\n\nRegards,\nStore Team";
        
        try {
            emailService.sendEmail(userEmail, subject, text);
        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle failure or log exception
        }
    }

    // You can create other methods to handle different notifications as well
}





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Sends an email to the specified recipient.
     * 
     * @param to The recipient's email address
     * @param subject The subject of the email
     * @param text The body of the email
     * @throws MessagingException if there is an error during the sending process
     */
    public void sendEmail(String to, String subject, String text) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        // Uncomment below to send attachments if needed
        // FileSystemResource file = new FileSystemResource(new File("path/to/file"));
        // helper.addAttachment("file.txt", file);

        mailSender.send(message);
    }
}

public class NotificationService {
    
}
