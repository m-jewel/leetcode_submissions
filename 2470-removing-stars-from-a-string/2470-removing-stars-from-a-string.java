class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        // Traverse the string
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // Remove the last character when encountering a star
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // Add non-star characters to the StringBuilder
                sb.append(c);
            }
        }

        // Convert the StringBuilder to a String and return
        return sb.toString();
    }
}
