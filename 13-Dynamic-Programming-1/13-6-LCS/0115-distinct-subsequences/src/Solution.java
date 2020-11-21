public class Solution {

    // 分类讨论：从 B 出发，的最后一个字符是不是在 A 的最后一个字符里出现
    // 1、不在 2、在

    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }

        // 分类计数加法原理
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen && j <= i; j++) {
                dp[i][j] = dp[i - 1][j] * 1;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1] * 1;
                }
            }
        }
        return dp[sLen][tLen];
    }
}