public class Solution2 {


    public boolean stoneGame(int[] piles) {

        // 区间 dp[i][j][k] 表示区间 [i, j] 里
        // k = 0 表示：Alex 作为先手可以获得的最大分数
        // k = 1 表示：Lee 作为先手可以获得的最大分数


        // 分类讨论的依据：只能选择左边或者右边

        int len = piles.length;
        int[][][] dp = new int[len][len][2];

        // 初始化，只有 1 堆的时候，Alex 作为先手，得分就是这堆里的石子数量
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][0] = piles[i];
            }
        }

        // 状态转移方程：
        // 注意填表顺序：

        // k 是子区间的长度
        for (int k = 2; k <= len; k++) {
            // i 是左边界
            for (int i = 0; i <= len - k; i++) {

                // 右边界
                int j = k + i - 1;

                int left = piles[i] + dp[i + 1][j][1];
                int right = piles[j] + dp[i][j - 1][1];

                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }

        }

        return dp[0][len - 1][0] - dp[0][len - 1][1] > 0;
    }
}
