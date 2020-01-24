public class Solution3 {

    // 题解：各位思考一下就知道，其实答案不就是求一波最长回文子序列，然后用字符串总长度减去最长回文子序列的长度即可。

    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        String s1 = stringBuilder.toString();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return n - dp[n][n];
    }

}
