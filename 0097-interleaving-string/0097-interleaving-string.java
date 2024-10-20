class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        
        // If the total length of s1 and s2 is not equal to s3, return false
        if (m + n != s3.length()) {
            return false;
        }
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: dp[0][0] = true, since empty s1 and s2 interleave to form empty s3
        dp[0][0] = true;
        
        // Fill the first row (when s2 is empty)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill the first column (when s1 is empty)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Fill the rest of the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the character from s1 matches the current character in s3
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                // If the character from s2 matches the current character in s3
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
