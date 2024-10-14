class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Create prefix product array
        answer[0] = 1;  // No elements to the left of index 0
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Calculate suffix product on the fly
        int suffix = 1;  // No elements to the right of last index
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;  // Multiply prefix with current suffix
            suffix *= nums[i];  // Update the suffix product
        }

        return answer;
    }
}