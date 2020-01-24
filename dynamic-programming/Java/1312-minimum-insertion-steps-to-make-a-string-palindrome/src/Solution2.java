public class Solution2 {

    public int minInsertions(String s) {
        int len = s.length();

        // dp[i][j]：表示让子串成为回文的最少插入次数
        // 注意：多设置了一行一列
        int[][] dp = new int[len + 1][len + 1];

        for (int i = 1; i < len; i++) {
            for (int j = 1; j + i <= len; j++) {
                dp[j][j + i] = Math.min(dp[j][j + i - 1], dp[j + 1][j + i]) + 1;


                if (s.charAt(j - 1) == s.charAt(j + i - 1)) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j + 1][j + i - 1]);
                }
            }

        }
        return dp[1][len];
    }
}
