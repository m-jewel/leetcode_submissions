class Solution {
    public String decodeString(String s) {
        // Stack for numbers (repeat counts) and stack for strings (current state)
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        
        // Current string and repeat count
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        
        // Traverse the string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the repeat count 'k'
                k = k * 10 + (c - '0'); // Or use Integer.parseInt(String)
            } else if (c == '[') {
                // Push current repeat count and current string onto stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for new substring
                currentString = new StringBuilder();
                k = 0;  // Reset count
            } else if (c == ']') {
                // Pop from stacks and repeat the string k times
                StringBuilder decodedString = stringStack.pop();
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }
                // Set the current string to the decoded string
                currentString = decodedString;
            } else {
                // Just a letter, so add it to the current string
                currentString.append(c);
            }
        }
        
        // Return the final decoded string
        return currentString.toString();
    }
}
