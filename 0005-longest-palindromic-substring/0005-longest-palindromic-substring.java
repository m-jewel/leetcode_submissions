class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Expand for odd-length palindrome (centered at i)
            int len1 = expandAroundCenter(s, i, i);
            // Expand for even-length palindrome (centered between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the longer palindrome between the odd and even cases
            int len = Math.max(len1, len2);
            
            // Update the start and end indices of the longest palindrome found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Helper function to expand around the center and find the length of the palindrome
    private int expandAroundCenter(String s, int left, int right) {
        // Expand as long as the characters on the left and right are the same
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}
