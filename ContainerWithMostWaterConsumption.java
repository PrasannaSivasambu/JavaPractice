public class ContainerWithMostWaterConsumption {

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7},left=0,right=height.length-1,maxVolume=0,volume=0;

        while(left<right){
            if(height[left]<height[right]){
                 volume=height[left]*(right-left);
                 System.out.println("Volume1"+" "+volume+ " height[left] "+height[left]+" "+(right+1)+" height[right] "+height[right] );
                 left++;
            }
            else{
                volume=height[right]*(right-left);
                System.out.println("Volume2"+" " +volume+ " height[left] "+height[left]+" height[right] "+height[right] +" "+(left+1));
                right--;
            }

            if(volume>maxVolume) maxVolume=volume;

            
        }
        System.out.println(maxVolume);


    }
    
}
