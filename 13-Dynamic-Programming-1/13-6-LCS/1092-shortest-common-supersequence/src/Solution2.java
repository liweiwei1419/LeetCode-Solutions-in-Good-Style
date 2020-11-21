public class Solution2 {

    // 两个字符串的最长公共子序列 LCS + 第一个字符串除去 LCS 之后的序列 + 第二个字符串除去 LCS 之后的序列
    // https://leetcode-cn.com/problems/shortest-common-supersequence/solution/javascript-2chong-si-lu-qiu-scs-by-da-fei-kai/
    // https://leetcode-cn.com/problems/shortest-common-supersequence/solution/lc1092-zui-duan-gong-gong-chao-xu-lie-by-fight_for/

    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // 先求最长公共子串
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = len1;
        int j = len2;
        StringBuilder stringBuilder = new StringBuilder();
        while (i > 0 || j > 0) {
            char current = ' ';
            if (i == 0) {
                current = charArray2[j - 1];
                j--;
            } else if (j == 0) {
                current = charArray1[i - 1];
                i--;
            } else if (charArray1[i - 1] == charArray2[j - 1]) {
                current = charArray1[i - 1];
                i--;
                j--;
            } else if (dp[i - 1][j] == dp[i][j]) {
                current = charArray1[i - 1];
                i--;
            } else if (dp[i][j - 1] == dp[i][j]) {
                current = charArray2[j - 1];
                j--;
            }
            stringBuilder.append(current);
        }
        return stringBuilder.reverse().toString();
    }
}