class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the total sum is odd, it's not possible to split an odd sum into two equal parts
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int target = totalSum / 2;
        
        // DP array to store whether a sum is possible with the current subset
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // Base case: sum 0 is always possible
        
        // Traverse through each number in nums
        for (int num : nums) {
            // Traverse from the target sum down to the current number to avoid overwriting
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        // The value at dp[target] will tell us whether it's possible to partition the array
        return dp[target];
    }
}
