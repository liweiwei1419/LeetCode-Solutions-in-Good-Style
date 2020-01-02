/**
 * 定义状态与状态转移方程：
 * dp[i]：爬到第 i 层（从 0 开始），需要花费的最少体力值
 * 需要说明的是：爬到这一层，不消耗这一层的体力值，因为这一层的体力值只表示向上跳要消耗的体力值
 * 很容易写出状态转移方程：
 * dp[i] = min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2])
 *
 * @author liwei
 */
public class Solution2 {

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
        int[] dp = new int[len + 1];
        // 注意：跳到第 0 阶和第 1 阶是不用消耗体力值的
        // 因为它们都可以作为跳台阶的起点(题目中说：在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。)
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[len];
    }
}
