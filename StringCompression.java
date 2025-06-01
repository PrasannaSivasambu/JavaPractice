import java.util.*;
import java.util.stream.Collectors;

public class StringCompression {

   
    //     String arr[]={"a","a","b","b","c","c","c"};

    //     char[] chars={'a','a','b','b'};
    //     IntStream.range(0, chars.length)
    // .mapToObj(i -> chars[i])
    // .collect(Collectors.groupingBy(
    //     c -> c,
    //     LinkedHashMap::new,
    //     Collectors.counting()
    // ));

    //     int[] i={1,2,3,4,5};
    //     Arrays.stream(i).boxed().collect(Collectors.groupingBy(e->e,LinkedHashMap::new,Collectors.counting()));

    //     // Arrays.stream(chars).m;
    //     List<String> list= new ArrayList<>();

    //     Map<String,Long> map= Arrays.stream(arr).collect(Collectors.groupingBy(e->e,LinkedHashMap::new,Collectors.counting()));
    //     for(Map.Entry<String, Long> m: map.entrySet()){
    //         if(m.getValue()>1){
    //             list.add(m.getKey());
    //             Character charValue = (char) m.getValue(); 
    //             list.add(charValue);
    //         }

    //     }
    //     String u[]=list.stream().toArray(String[]::new);

     public static int compress(char[] chars) {
        int index = 0; // write index
        int i = 0;     // read index

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count frequency of currentChar
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character
            chars[index++] = currentChar;

            // Write the count (if more than 1)
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index; // new length
    }

    public static void main(String[] args) {
        char[] arr = {'a','a','b','b','c','c','c'};
        int newLength = compress(arr);
        System.out.println("Compressed: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    
}
