public class Solution2 {

    // 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。

    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0) {
            return 0;
        }

        int[][] dp = new int[sLen + 1][tLen + 1];
        // 初始化
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        // 递推开始
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                dp[i][j] = dp[i - 1][j];
                if (sCharArray[i - 1] == tCharArray[j - 1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[sLen][tLen];
    }
}