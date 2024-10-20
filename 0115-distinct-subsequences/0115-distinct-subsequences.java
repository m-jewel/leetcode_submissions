class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length(); 
        
        int[][] dp = new int[m + 1][n + 1];

        // Base case: If t is an empty string, there is exactly 1 way to match it from any string s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Characters match: include the match or exclude the character in s
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Characters don't match: exclude the character in s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
