public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents integer overflow
            System.out.println( "Left "+ left+ " Right "+ right+" Mid "+mid);
            if (arr[mid] == target)
                return mid; // Target found
            
            if (arr[mid] < target)
                left = mid + 1; // Search in right half
            else
                right = mid - 1; // Search in left half
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72,75};
        int target = 56;
        int result = binarySearch(arr, target);
        
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }
}
