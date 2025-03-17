import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagrams {
 
    
    public static void main(String[] args) {
        String arr[] = { "abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm" };

        // Arrays.stream(arr)
        // .map(e->e.chars().mapToObj(Character::toString).sorted().collect(Collectors.joining("")))
        // .collect(Collectors.groupingBy(Function.identity(),Collectors.toList()))
        // .values().stream()
        // .forEach(System.out::println);;



        Arrays.stream(arr)
        .collect(Collectors.toMap(key->{
           return  key.chars().mapToObj(Character::toString).sorted().collect(Collectors.joining(""));  
        }, value->{
            List<String> l= new ArrayList<>();
            l.add(value);
            return l;
        },
        (e1,e2)->{
            e1.addAll(e2);
          return e1 ;
        }

        ))
        .values().stream()
        .forEach(System.out::println);


      System.out.println(  new ArrayList<>(
            Arrays.stream(arr)
                  .collect(Collectors.groupingBy(
                      str -> {
                          char[] chars = str.toCharArray();
                          Arrays.sort(chars);
                          return new String(chars);
                      }
                  ))
                  .values()
        ));

        Optional<Integer> n= Optional.ofNullable(1);

        List<Integer> numbers=new ArrayList<>(Arrays.asList(2,1,1,2,3,3,4));

        int c= numbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
        .stream().sorted((a1,a2)->a1.getKey().compareTo(a2.getKey()))
        .sorted((a1,a2)->a2.getValue().compareTo(a1.getValue())).findFirst().get().getKey();

                    

        System.out.println(c);
//  List<Integer> k=new ArrayList<>();
//  k.
    }
}
