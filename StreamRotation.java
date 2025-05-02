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
    }
}
