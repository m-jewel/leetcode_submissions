class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // If the characters are the same, take it from both strings
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // If the character comes from str1, append it and move up in str1
                result.append(str1.charAt(i - 1));
                i--;
            } else {
                // If the character comes from str2, append it and move left in str2
                result.append(str2.charAt(j - 1));
                j--;
            }
        }
        
        // If there are remaining characters in str1 or str2, append them
        while (i > 0) {
            result.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            result.append(str2.charAt(j - 1));
            j--;
        }
        
        return result.reverse().toString();
    }
}