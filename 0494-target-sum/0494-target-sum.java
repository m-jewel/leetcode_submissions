class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        if (target > totalSum || (totalSum + target) % 2 != 0) {
            return 0; // Not possible to partition
        }
        
        // Find subset sum equal to (target + totalSum) / 2
        int sum = (totalSum + target) / 2;
        if (sum < 0) {
            return 0;
        }
        return countSubsets(nums, sum);
    }
    
    // Helper function to count the number of subsets that sum to a given target
    private int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // There is one way to achieve sum 0 (by choosing no elements)
        
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[target];
    }
}
