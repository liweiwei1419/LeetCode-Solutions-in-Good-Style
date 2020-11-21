public class Solution6 {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[3];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i++) {
            dp[i % 3] = Math.min(dp[(i - 1) % 3], dp[(i - 2) % 3]) + cost[i];
        }
        return Math.min(dp[(len - 1) % 3], dp[(len - 2) % 3]);
    }
}