public class Solution {

    /**
     * 假设金额为 M，硬币数为 N
     * 时间复杂度：O(N*M*M)
     * 空间复杂度：O(N*M)
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        // 语义：什么物品都不选，填充价值为 0 的背包的组合为 1
        // 这个初值很重要，后续填写表格的时候会用到
        dp[0][0] = 1;

        // 一枚硬币一枚硬币地考虑进去，所以外层循环是硬币序号
        // 注意：此时第 0 行我们先把它填上去，后续第 i 行参考第 i - 1 行的值
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                // 对于使用的硬币数还要再做一次循环
                for (int k = 0; j - k * coins[i - 1] >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }
        return dp[len][amount];
    }
}
