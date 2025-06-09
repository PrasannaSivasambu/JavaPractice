import java.util.*;
import java.util.stream.*;

public class StreamRotation {
    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4, 5);
        int n = 2;

        int size = input.size();
        int rotation = size - (n % size);
        System.out.println(rotation);

        List<Integer> rotated = IntStream.range(0, size)
            .mapToObj(i -> input.get((i + rotation) % size))
            .collect(Collectors.toList());

        System.out.println(rotated); // [4, 5, 1, 2, 3]

        String s="abcdef";
        int leftshift=2,rightshift=2;
        System.out.println("LeftShift "+  s.substring(leftshift,s.length())+s.substring(0,leftshift) );
        System.out.println("RightShift "+  s.substring(s.length()-rightshift)+s.substring(0,s.length()-rightshift) );


        Set<String> set=new HashSet<>();
        set.add("qw");
         System.out.println(set.contains("qw"));


    }
}
