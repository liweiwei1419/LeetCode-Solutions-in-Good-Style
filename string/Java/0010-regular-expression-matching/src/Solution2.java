/**
 * @author liweiwei1419
 * @date 2019/9/22 8:20 下午
 */
public class Solution2 {

    // 动态规划

    private boolean firstMatch(String s, String p, int i, int j) {
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int j = 2; j <= pLen; j++) {
            // 如果当前 p 看到的是 * ，直接砍掉 2 个模式串即可
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                if (p.charAt(j) == '*') {
                    if (dp[i + 1][j - 1]) {
                        // 砍去头两个
                        dp[i + 1][j + 1] = true;
                    } else {
                        // 砍去文本串的头一个
                        dp[i + 1][j + 1] = firstMatch(s, p, i, j - 1) && dp[i][j + 1];
                    }
                } else {
                    dp[i + 1][j + 1] = firstMatch(s, p, i, j) && dp[i][j];
                }

            }
        }
        return dp[sLen][pLen];
    }
}
