class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if(n == 0){
            return "";
        }

        boolean[][] dp = new boolean[n][n];

        int maxLength = 1;
        int start = 0;

        // Base Cases:
        // Any single character is a palindrome by itself, so dp[i][i] = true.
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        // Two consecutive equal characters are also palindromes, so for every i, if s[i] == s[i + 1], then dp[i][i + 1] = true.
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for palindromes of length greater than 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index of the substring
                
                // Check if the first and last characters are the same and if the substring inside them is also a palindrome. If both conditions are true, the current substring is a palindrome.
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}