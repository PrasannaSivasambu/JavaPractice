import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairsSumNotSorted {
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE = ALPHABET.length();

    private static String encode(Long num) {
       
       
      
        StringBuilder sb = new StringBuilder();
        // while (number > 0) {
        //     System.out.println(num+" "+BASE+" "+(number % BASE)+" "+(number/ BASE));
        //     sb.append(ALPHABET.charAt((int)(number % BASE)));
        //     number =number/ BASE;
           
        // }

        double h=Math.random();
        String s=Long.toString(num)+Double.toString(h).substring(2);
        return s;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 10,i=0,anotherElement=0,M=0;

        Set<Integer> s= new HashSet<>(Arrays.stream(arr).boxed().toList());
        
        while(i<arr.length){
            anotherElement=target-arr[i];
            if(s.contains(anotherElement)){
                System.out.println(arr[i]+" "+anotherElement);
            }
            i++;
        }

        Arrays.stream(arr).forEach(number->{
           int AnotherElement=target-number;
           if(s.contains(AnotherElement)){
            System.out.println(number+" "+AnotherElement);
            }
        });

        System.out.println( "Create "+encode((long)4));
   
       
    }
    
}
