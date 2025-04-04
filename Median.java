import java.util.Arrays;

public class Median  {


    private static int findMedian(){
        int[] a={6,2,1,1,1,1,2};

        int totalsum=Arrays.stream(a).sum(),leftSum=0,rightSum=0;

        for(int i=0; i<a.length; i++){
         
            rightSum=totalsum-leftSum-a[i];

            if(rightSum==leftSum){

               return a[i];
               
            }

            leftSum=leftSum+a[i];
        }
       return 0;
    }

    public static void main(String[] args) {
       System.out.println( Median.findMedian());
    }
    
}
