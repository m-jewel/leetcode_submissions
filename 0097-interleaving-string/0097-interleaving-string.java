class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        // If the total length of s1 and s2 is not equal to s3, return false
        if (m + n != s3.length()) {
            return false;
        }
        
        boolean[] dp = new boolean[n + 1];
        // Initialize the DP array for the base case (when s1 is empty)
        dp[0] = true;
        
        // Populate the DP array for the case where s1 is empty and s2 is compared with s3
        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Traverse over s1 and update the DP array based on matches with s3
        for (int i = 1; i <= m; i++) {
            // Update dp[0] for the case where s2 is empty and s1 is compared with s3
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                // Check if the current character in s3 matches either from s1 or s2
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[n];
    }
}
