class Solution {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        s = s.trim();

        // Convert to a character array to manipulate in-place
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Reverse the entire character array
        reverse(chars, 0, n - 1);

        // Reverse each word again in the reversed string
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (chars[end] == ' ') {
                // Reverse the word
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
        // Reverse the last word
        reverse(chars, start, n - 1);

        // Clean up spaces and build the final string
        return cleanSpaces(chars, n);
    }

    // Helper method to reverse a part of the array
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    // Helper method to clean up spaces
    private String cleanSpaces(char[] chars, int n) {
        int i = 0, j = 0;
        while (j < n) {
            // Skip spaces
            while (j < n && chars[j] == ' ') j++;
            // Copy non-space characters
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            // Add a single space if there's more to process
            while (j < n && chars[j] == ' ') j++;
            if (j < n) chars[i++] = ' ';
        }
        return new String(chars, 0, i);
    }
}