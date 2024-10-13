class Solution {
    public String reverseVowels(String s) {
        // Set to hold vowels for quick lookup
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // Convert string to character array for in-place modification
        char[] chars = s.toCharArray();
        
        // Initialize two pointers
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            // Move left pointer until a vowel is found or until pointers cross
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            // Move right pointer until a vowel is found or until pointers cross
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Swap the vowels found at left and right
            if(left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        // Convert character array back to string
        return new String(chars);
    }
}