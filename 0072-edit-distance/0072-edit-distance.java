class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Fill the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  // Deleting all characters in word1 to match an empty word2
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  // Inserting all characters into word1 to match word2
        }

        // Fill the DP table using the recurrence relation
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    // Characters match, no edit needed
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    // Take the minimum of insert, delete, or replace operation
                    dp[row][col] = 1 + Math.min(dp[row - 1][col], 
                                     Math.min(dp[row][col - 1], dp[row - 1][col - 1]));
                }
            }
        }

        return dp[m][n];
    }
}
