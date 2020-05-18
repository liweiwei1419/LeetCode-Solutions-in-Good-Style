public class Solution7 {

    // 花花酱的思路 2：动态规划

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }

        // 注意顺序，新值一定要参考旧址
        for (int k = 2; k <= len; k++) {
            // i 表示左边界
            for (int i = 0; i < len - k + 1; i++) {
                // j 表示右边界
                int j = i + k - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] > 0;
    }
}
