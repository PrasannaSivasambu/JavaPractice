import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class java9 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 0, 6, 7, 8, 9, 10);

                    List<Integer> dropWhileResult = numbers.stream()
                            .dropWhile(n -> n < 5)
                            .collect(Collectors.toList());

                    // skip() skips first 5 elements unconditionally
                    List<Integer> skipResult = numbers.stream()
                            .skip(5)
                            .collect(Collectors.toList());

                    System.out.println("dropWhile Result: " + dropWhileResult);
                    System.out.println("skip Result: " + skipResult);


         // takeWhile() stops at first non-matching element
         List<Integer> takeWhileResult = numbers.stream()
         .takeWhile(n -> n < 5)
         .collect(Collectors.toList());

        // limit() simply takes first 5 elements
        List<Integer> limitResult = numbers.stream()
         .limit(5)
         .collect(Collectors.toList());

        System.out.println("takeWhile Result: " + takeWhileResult);
        System.out.println("limit Result: " + limitResult);


                    Stream.iterate(1, n -> n + 2) // Generates: 1, 3, 5, 7, 9, ...
                        .limit(5)
                        .forEach(System.out::println);


        Optional<Integer> o= Optional.ofNullable(null);
        // Optional<Integer> op= Optional.of(null);

        int m=o.orElse(0);
        System.out.println(m);
    }
    
}
