class Solution {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        long[] dp = new long[n + 1];
        long[] g = new long[n + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        g[2] = 1;
        g[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * g[i - 1]) % MOD;
            g[i] = (g[i - 1] + dp[i - 2]) % MOD;
        }

        return (int) dp[n];
    }
}
