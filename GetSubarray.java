import java.util.*;
import java.util.concurrent.CompletableFuture;

public class GetSubarray {
    public static List<List<Integer>> getValidSubarrays(List<Integer> arr) {
        int n = arr.size();
        List<List<Integer>> result = new ArrayList<>();

        for (int start = 0; start < n; start++) {
            Set<Integer> elements = new HashSet<>();
            for (int end = start; end < n; end++) {
                elements.add(arr.get(end));
                int length = end - start + 1;
                if (elements.contains(length)) {
                    result.add(arr.subList(start, end + 1)); // This is a view, safe to use as read-only
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 1);
        List<List<Integer>> validSubarrays = getValidSubarrays(arr);

        for (List<Integer> sub : validSubarrays) {
            System.out.println(sub);
        }

        CompletableFuture c = new CompletableFuture();

        
    }


}
