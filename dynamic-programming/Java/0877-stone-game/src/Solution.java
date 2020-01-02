import java.util.Arrays;

public class Solution {

    // dp[i][j]：从 i 到 j 所能获得的最大的绝对分数
    // 1：就说明亚历克斯从 i 到 j 可以赢李 1 分

    // （难点）状态转移方程：

    // dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);

    public boolean stoneGame(int[] piles) {
        // 这里减去 dp 数组是因为李也要找到最大的
        int len = piles.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            // dp[i][i]：存储当前 i 的石子数
            dp[i][i] = piles[i];
        }
        // d = 1 表示先算两个子的时候
        for (int d = 1; d < len; d++) {
            // 有多少组要比较
            for (int j = 0; j < len - d; j++) {
                // 比较 j 到 d + j
                dp[j][d + j] = Math.max(piles[j] - dp[j + 1][d + j], piles[d + j] - dp[j][d + j - 1]);
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][len - 1] > 0;
    }

    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        Solution solution = new Solution();
        boolean res = solution.stoneGame(piles);
        System.out.println(res);
    }
}
