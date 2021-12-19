public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        // 阶段
        for (int i = 1; i <= len; i++) {
            int[] cnt = countZeroAndOne(strs[i - 1]);
            // 状态 1
            for (int j = 0; j <= m; j++) {
                // 状态 2
                for (int k = 0; k <= n; k++) {
                    // 按照「0-1 背包问题」的状态转移过程，先把上一行的值抄下来
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = cnt[0];
                    int ones = cnt[1];
                    // 决策
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    /**
     * 分别统计每个单词 0 和 1 出现的次数
     *
     * @param str
     * @return
     */
    private int[] countZeroAndOne(String str) {
        int[] counter = new int[2];
        for (char c : str.toCharArray()) {
            counter[c - '0']++;
        }
        return counter;
    }
}