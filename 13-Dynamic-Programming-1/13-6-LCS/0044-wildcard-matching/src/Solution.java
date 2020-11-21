public class Solution {

    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        // 初始化
        dp[0][0] = true;
        for (int i = 1; i <= len2; i++) {
            if (pCharArray[i - 1] == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        // 递推开始：内外层循环都从 1 开始，到字符串的长度结束
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 注意这里，字符串有一个偏移，所以要减 1
                if (pCharArray[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pCharArray[j - 1] == '?' || sCharArray[i - 1] == pCharArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}