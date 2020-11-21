public class Solution {

    // 区别于最长公共子序列，本题要求子数组，子数组的特征是连续
    // 只需要返回长度，所以可以考虑使用
    // 方法一：动态规划

    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        dp[0][0] = 0;
        // 递推开始
        int res = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}