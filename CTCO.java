import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CTCO {
    public static void main(String[] args) {
        String input = "lalit";
        input.chars().mapToObj(Character::toString).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
        .entrySet().stream().filter(u->u.getValue()<2).limit(1).forEach(ele->System.out.println(ele.getKey()));

        List<Integer> numbers=Arrays.asList(1, 2, 3, 4,5,5,5,5);
        // int sum = numbers.parallelStream().reduce(2, Integer::sum);      
        // System.out.println(sum);

        int sumi = numbers.parallelStream().reduce(2, (a, b) -> {
            System.out.println("a: " + a + ", b: " + b);
            return a + b;
        });
        System.out.println(sumi);
         
           
 
    }
}
