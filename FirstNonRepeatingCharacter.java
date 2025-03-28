import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                .max((a1,a2)->a1.getValue().compareTo(a2.getValue()));

                if (c.isPresent()) {
                  return c.get().getKey();  
                }
                return 0;
                
    }
    public static void main(String[] args) {
        int[] n={1,2,2,3,4,5,6};

        System.out.println( Arrays.stream(n).boxed().collect(Collectors.groupingBy(e->e)) );
        String f="Prasanna";
        char es='a';
        int b=(int) f.chars().map(i->(char)i).filter(e->e==es).count();


    

        Integer[] mf= Arrays.stream(n).boxed().toArray(Integer[]::new);
        System.out.println("hello " +FirstNonRepeatingCharacter.findMostFrequentElement(n)+" " + b);


        List<Integer>[] list=new ArrayList[9];
        list[0]= new ArrayList<>();

    }
    
}
