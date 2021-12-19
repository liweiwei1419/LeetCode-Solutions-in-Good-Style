import java.util.Arrays;

class Solution10 {

    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[][] dp = new int[2][amount + 1];
        // 这个值语义不正确，但是是一个被其它状态参考的值，这样设置是正确的
        dp[0][0] = 1;

        // 填第 1 行
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < len; i++) {
            // 注意：如果写成滚动数组的情况，这一行完全参考上一行的值
            // 当前行的值应该先清空为 0，这是因为 j - k * coins[i] >= 0 的时候才计算结果
            // 如果不清空为 0，就有可能引用到错误的结果
            Arrays.fill(dp[i & 1], 0);

            for (int j = 0; j <= amount; j++) {
                for (int k = 0; j - k * coins[i] >= 0; k++) {
                    dp[i & 1][j] += dp[(i - 1) & 1][j - k * coins[i]];
                }
            }
        }
        return dp[(len - 1) & 1][amount];
    }

}