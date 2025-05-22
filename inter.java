import java.util.Arrays;

public class inter {
    public static void main(String[] args) {
//         int i[]={1,2,3,4,5,5,6};

// int start=0, end=1,maxLength=0,count=0;
	
//    while(end<i.length){

	
// 	if(i[start]==i[end]){
// 		count=count+1;
// 		maxLength=Math.max(maxLength, count);
// 		end++;
// 	}
// 	else{
// 		count=0;
// 		start++;
// 	}

	
//      }
//      System.out.println(maxLength);

int arr[] = {0, 1, 0, 3, 12};


int i=0,j=1;

while(j<arr.length){

   if(arr[i]==0){
	int temp=arr[i];
	arr[i]=arr[j];
	arr[j]=temp;
	j++;
    }
    else{
	i++;
    }
}
    System.out.println(Arrays.toString(arr));  
    }
    
    
}
