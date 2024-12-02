public class LargestThreeNumbers {
    public static void main(String[] args) {
        int a[]={10,2,3,13,20,23,45,34,22,55,80,44};
        int first=a[1], second=a[2];
        for(int i=0; i<a.length; i++){
            if(a[i]>first){
                second=first;
                first=a[i];
            }
        }
        System.out.println(first+" "+second);
    }
}
