class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // Special cases when there are very few steps
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        
        int[] dp = new int[n + 1];
        
        // Start from either the first or the second step (you can start from index 0 or 1)
        dp[0] = 0;
        dp[1] = 0;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
}
