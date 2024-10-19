class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }
        
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: sum of 0 is always achievable

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }
        
        // Find the largest sum we can achieve that is <= target
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                return totalSum - 2 * i; // The smallest difference
            }
        }
        
        return 0; // No stones are left
    }
}
