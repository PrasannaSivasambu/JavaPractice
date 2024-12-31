import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pairsfindingsumlessthan5 {
    public static void main(String[] args) {
        Integer a[]={-3,-2,0,1,3,4,5,8},i=0,j=a.length-1;
        
        Set<Integer> set= new HashSet<>(Arrays.asList(a));
        List<List<Integer>> list= new ArrayList<>(); 

        for(int x=0; x<a.length; x++){
            for(int y=a.length-1; y>=x+1; y--){
                if(a[x]+a[y]<5){
                    list.add(new ArrayList<>(Arrays.asList(a[x],a[y])));
                }
            }
        }

        // int i = 0, j = a.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (i < j) {
            if (a[i] + a[j] < 5) {
                result.add(new ArrayList<>(Arrays.asList(a[i], a[j])));
                j--; // Try the next smaller value
            } else {
                i++; // Move to the next larger value
            }
        }
        System.out.println(result);
        // for(int m=0; m<a.length; m++){

        // }

        System.out.println(list);
    }
    
}
