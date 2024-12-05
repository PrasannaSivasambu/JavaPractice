import java.util.ArrayList;
import java.util.List;

public class SubsetGeneration {
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add current subset
        System.out.println("result.add(new ArrayList<>(tempList)); "+result+" "+tempList+" "+" "+start);
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            System.out.println(" tempList.add(nums[i]); "+result+" "+tempList+" "+start); // Include current element
            backtrack(result, tempList, nums, i + 1); // Recurse with the next element
            tempList.remove(tempList.size() - 1); // Backtrack
            System.out.println(" tempList.remove(tempList.size() - 1); "+result+" "+tempList+" "+start);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(generateSubsets(nums));
    }
}
