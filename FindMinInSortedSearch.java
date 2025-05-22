
public class FindMinInSortedSearch {
    /* pick the Sorted array and consider  that as minimum */

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 6, 1, 2};

        System.out.println(smallest(a));

    }

    private static int smallest(int[] a) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = a.length - 1;
        int mid = 0;


        while (low <= high) {
            mid = (low + high) / 2;

            if (a[low] <= a[mid]) {
                min = Math.min(min, a[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, a[mid]);
                high = mid - 1;
            }
        }


        return min;
    }
}
