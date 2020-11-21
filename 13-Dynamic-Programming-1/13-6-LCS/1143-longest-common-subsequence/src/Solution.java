public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        // dp[i][j]：长度为 i 的 text1 前缀字符串与长度为 j 的 text2 前缀字符串的最长公共子串的长度
        // 字符串的问题需要考虑空串，所以多开一行，多开一列
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = 0;
        }

        // 由于通过下标访问字符的 charAt() 方法每一次都会去检查下标是否越界
        // 通常，字符串的遍历先将字符串转为字符数组
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        // 递推开始
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 以 dp 表格为基准，访问字符串下标需要减 1
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}