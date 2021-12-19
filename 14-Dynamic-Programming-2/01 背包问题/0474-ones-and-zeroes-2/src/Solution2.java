public class Solution2 {

    // 多维费用问题的 0-1 背包问题（空间优化的写法）

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        if (len == 0) {
            return 0;
        }

        // dp[i][j] 表示使用 i 个 0 和 j 个 1 能表示的字符串的最大数量
        // 状态转移方程：dp[i][j] = Math.max(dp[i][j],1+dp[i-numZero][j-numOne])
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            // 统计字符串中一和零的数量。
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }
        return dp[m][n];
    }
}