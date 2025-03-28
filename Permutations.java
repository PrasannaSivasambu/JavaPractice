import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        System.out.println( "Result "+result+" TemplList "+tempList+" nums "+Arrays.toString(nums));
        System.out.println();
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add current permutation
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // Skip used elements
                tempList.add(nums[i]); // Include current element
                backtrack(result, tempList, nums); // Recurse
                tempList.remove(tempList.size() - 1); // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(generatePermutations(nums));
    }
}

// []
// ├── [1]
// │   ├── [1, 2]
// │   │   ├── [1, 2, 3]
// │   │   └── [1, 3, 2]
// │   └── [1, 3]
// │       ├── [1, 3, 2]
// │       └── [1, 2, 3]
// ├── [2]
// │   ├── [2, 1]
// │   │   ├── [2, 1, 3]
// │   │   └── [2, 3, 1]
// │   └── [2, 3]
// │       ├── [2, 3, 1]
// │       └── [2, 1, 3]
// └── [3]
//     ├── [3, 1]
//     │   ├── [3, 1, 2]
//     │   └── [3, 2, 1]
//     └── [3, 2]
//         ├── [3, 2, 1]
//         └── [3, 1, 2]

