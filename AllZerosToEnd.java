import java.util.Arrays;

public class AllZerosToEnd {
    public static void main(String[] args) {
        
        int left=0,right=1,arr[]={0,0,2,4,0,2,3,0,0,9,8,7,0,6,0,5};
       while (right<arr.length) {
        if(arr[left]==0){
            int temp=arr[right];
            arr[right]=arr[left];
            arr[left]=temp; //true
        }
        if(arr[left]!=0){
            left++;
       }
       right++;
    }
    System.out.println(Arrays.toString(arr));
}
    
}
