public class Solution {

    // 最长公共子序列

    public int maxUncrossedLines(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
