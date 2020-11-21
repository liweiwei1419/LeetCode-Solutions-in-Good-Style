public class Solution {

    // 定义状态 dp[i] ：第 i 层必须爬，消耗的体力花费最小值

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return cost[0];
        }
        if (len == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        // 根据状态的定义，要爬到编号为 len 的那一层（即楼顶）
        // 有两种选择：
        // （1）爬到 len - 1 层，再上一层到楼顶
        // （2）爬到 len - 2 层，再上两层到楼顶
        return Math.min(dp[len - 1], dp[len - 2]);
    }
}