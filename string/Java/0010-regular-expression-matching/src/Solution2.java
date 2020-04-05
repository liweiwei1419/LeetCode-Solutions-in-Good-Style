public class Solution2 {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        // 记录文本符串 s[0, i) 是否匹配模式字符串 p[0, j)
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        // 初始化 begin
        dp[0][0] = true;
        for (int j = 1; j < pLen; j++) {
            // 如果当前 p 看到的是 * ，直接砍掉 2 个模式串
            dp[0][j + 1] = pCharArray[j] == '*' && dp[0][j - 1];
        }
        // 初始化 end

        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {

                if (pCharArray[j] == '*') {
                    // 下面开始分类讨论
                    // 把 '*' 当前面的字符使用 0 次，全程注意有 1 个偏移的量
                    if (dp[i + 1][j - 1]) {
                        dp[i + 1][j + 1] = true;
                    } else {
                        // 就这里巨难理解

                        // 砍去文本串的头一个
                        dp[i + 1][j + 1] = firstMatch(sCharArray, pCharArray, i, j - 1) && dp[i][j + 1];
                    }

                } else {
                    dp[i + 1][j + 1] = firstMatch(sCharArray, pCharArray, i, j) && dp[i][j];
                }
            }
        }
        return dp[sLen][pLen];
    }

    private boolean firstMatch(char[] sCharArray, char[] pCharArray, int i, int j) {
        return sCharArray[i] == pCharArray[j] || pCharArray[j] == '.';
    }
}
