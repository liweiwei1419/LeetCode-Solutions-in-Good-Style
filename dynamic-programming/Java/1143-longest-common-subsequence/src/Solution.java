public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();

        // 字符串的问题多开一行，多开一列
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (charArray1[i] == charArray2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text1 = "abcde";
        String text2 = "ace";
        int res = solution.longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }
}
