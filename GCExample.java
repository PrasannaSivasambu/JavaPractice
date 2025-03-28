import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GCExample {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
         List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Jake");

        names.stream()
             .filter(name -> {
                 System.out.println("Filtering: " + name);
                 return name.startsWith("J");
             })
             .map(name -> {
                 System.out.println("Mapping: " + name);
                 return name.toUpperCase();
             })
             .forEach(System.out::println);
    }
}
