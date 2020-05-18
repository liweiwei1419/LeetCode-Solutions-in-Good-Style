public class Solution3 {

    // 状态压缩
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[2][len];
        // k 表示区间长度
        for (int k = 1; k <= len; k++) {
            // i 表示区间左端点
            for (int i = 0; i + k - 1 < len; i++) {
                // j 表示区间右端点
                int j = i + k - 1;
                if (i == j) {
                    dp[i & 1][i] = piles[i];
                } else {
                    dp[i & 1][j] = Math.max(piles[i] - dp[(i + 1) & 1][j], piles[j] - dp[i & 1][j - 1]);
                }
            }
        }
        return dp[0][len - 1] > 0;
    }
}