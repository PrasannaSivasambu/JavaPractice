import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static String longestPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: Single character palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill DP table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));
        System.out.println(Arrays.toString(dp[4 ]));
        // Reconstruct LPS string using the DP table
        int i = 0, j = n - 1;
        StringBuilder leftPart = new StringBuilder();
        StringBuilder rightPart = new StringBuilder();

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                leftPart.append(s.charAt(i));
                if (i != j) {  // Avoid adding middle element twice for odd length LPS
                    rightPart.insert(0, s.charAt(j));
                }
                i++;
                j--;
            } else if (dp[i + 1][j] > dp[i][j - 1]) {
                i++;  // Move towards the larger subsequence
            } else {
                j--;
            }
        }

        // Combine both parts
        return leftPart.toString() + rightPart.toString();
    }

    public static void main(String[] args) {
        String s = "bbbab";
        String lps = longestPalindromicSubsequence(s);
        System.out.println("Longest Palindromic Subsequence: " + lps);
    }
}
