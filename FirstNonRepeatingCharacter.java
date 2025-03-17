import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {
    private static int findMostFrequentElement(int[] arr){
        Optional<Map.Entry<Integer,Long>> c= Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

                if (c.isPresent()) {
                  return c.get().getKey();  
                }
                return 0;
                
    }
    public static void main(String[] args) {
        int[] n={1,2,2,3,4,5,6};
        System.out.println( FirstNonRepeatingCharacter.findMostFrequentElement(n));
    }
    
}
