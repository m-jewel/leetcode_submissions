class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        
        boolean[] travelDays = new boolean[lastDay + 1];
        for (int day : days) {
            travelDays[day] = true;
        }

        for (int i = 1; i <= lastDay; i++) {
            // If it's not a travel day, the cost remains the same as the previous day
            if (!travelDays[i]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[i - 1] + costs[0], // 1-day pass
                         Math.min(dp[Math.max(0, i - 7)] + costs[1], // 7-day pass
                                  dp[Math.max(0, i - 30)] + costs[2])); // 30-day pass
            }
        }

        return dp[lastDay];
    }
}
