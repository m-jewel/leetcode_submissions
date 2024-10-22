class Solution {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;

        // Base Cases
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 5;

        long[] dp = new long[n + 1];
        long[] g = new long[n + 1]; // For tromino overlaps multiple tiles

        dp[1] = 1; // Only one way to tile a 2 x 1 board
        dp[2] = 2; // Either two vertical dominoes or two horizontal dominoes
        dp[3] = 5; // Example 1
        
        g[2] = 1;
        g[3] = 2;

        for(int i = 4; i <= n; i++){
            // Place a vertical domino + two horizontal dominoes + trominoes which has two orientations hence times by two
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * g[i - 1]) % MOD;
            g[i] = (g[i - 1] + dp[i - 2]) % MOD; // Count both partial and full tilings for trominoes
        }

        return (int)dp[n];
    }
}