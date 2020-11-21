public class Solution {

    // 方法一：动态规划

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        // 转换成字符数组，以便通过下标访问字符
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // 初始化，填写第 0 行、第 0 列
        dp[0][0] = true;
        for (int j = 1; j <= pLen; j++) {
            // 如果当前 p 看到的是 * ，直接砍掉 2 个模式串
            if (pCharArray[j - 1] == '*' && j >= 2) {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 递推开始，注意：状态数组从 1 开始，字符下标访问的时候要减 1
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (pCharArray[j - 1] != '*') {
                    if (match(sCharArray, i - 1, pCharArray, j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    continue;
                }
                // 此时 pCharArray[j - 1] == '*' 成立
                if (match(sCharArray, i - 1, pCharArray, j - 2)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                } else {
                    dp[i][j] = dp[i][j - 2];
                }
            }
        }
        return dp[sLen][pLen];
    }

    /**
     * @param sCharArray
     * @param i
     * @param pCharArray
     * @param j
     * @return sCharArray[i] 与 pCharArray[j] 是否匹配，pCharArray[j] 可以是 '.'
     */
    private boolean match(char[] sCharArray, int i, char[] pCharArray, int j) {
        return sCharArray[i] == pCharArray[j] || pCharArray[j] == '.';
    }
}