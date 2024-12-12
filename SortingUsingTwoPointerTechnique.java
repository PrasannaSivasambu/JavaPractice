import java.util.Arrays;

public class SortingUsingTwoPointerTechnique {

    public static int[] sorting(int[] x, int[] y){
        int len=x.length+y.length;

        int i=0,j=0,l=0;
        int[] result = new int[len];
        
            while (i<x.length && j<y.length) {
                if(x[i]<=y[j]){
                    result[l++]=x[i];
                    i++;
                }
                else{
                    result[l++]=y[j];
                    j++;
                }
            }
            while (i<x.length) {
                result[l++]=x[i++];
                
            }
            while (j<y.length) {
                result[l++]=y[j++];
                
            }

            System.out.println(Arrays.toString(result));
        return result;
        

    }


    public static void main(String[] args) {
        int a[]={2,4,5,6,7},b[]={3,5,8,9,10};
        int[] c= sorting(a,b);
    }
}
