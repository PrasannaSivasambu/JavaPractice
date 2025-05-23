import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NewAnagram {

    public static boolean isAnotherAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[256]; // Supports all characters
        int nonZeroCount = 0; // Tracks number of non-zero values

        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (++count[ch1] == 1) nonZeroCount++; // Increment count, track if it was 0 before
            if (--count[ch2] == 0) nonZeroCount--; // Decrement count, track if it became 0

        }

        return nonZeroCount == 0; // If all counts are balanced, it's an anagram
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[256]; // Supports all ASCII characters

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

    private static void frequentSmallNo(List<Integer> list){

   System.out.println( list.stream().collect(Collectors.groupingBy(e->e,Collectors.counting())).entrySet().stream()
    .sorted((a1, a2) -> 
    a1.getValue().compareTo(a2.getValue())!=0 ? a2.getValue().compareTo(a1.getValue())
                                              : a1.getKey().compareTo(a2.getKey())  
    ).limit(1).findFirst().get().getKey());
    

    System.out.println( list.stream().collect(Collectors.groupingBy(e->Integer.toString(e),Collectors.maxBy((r1,r2)->r2.compareTo(1)))));
    

    }

    public static void main(String[] args) {
        
        String s1="";
        String s2="";

        if (s1==null || s2==null) {
            System.out.println("false");
        }

        char[] c=s1.toCharArray(),d=s2.toCharArray();

        Arrays.sort(c);
        Arrays.sort(d);

        if (Arrays.equals(c,d)) {
            System.out.println("true");
        }
        else System.out.println("false");


        List<Integer> list=List.of(1,2,3,4,5,1,2,3);

       frequentSmallNo(list);

       int[] count = new int[256]; 

       System.out.println("kilo "+count['c']+" "+'c');

    //    int x=2;
Function<Integer,Integer> f=(x)->x*x;
Predicate<Integer> p= (r)->r==2;

p.test(2);

int nc='A';

System.out.println(nc);

int[] counti = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLength = 0;

        count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
    }
    
}
