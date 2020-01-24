public class Solution {

    // 这道题不同的是二维数组数组 dp[i][j]，
    // 表示的不是数组 A 从 0 到 i - 1 与 数组 B 从 0 到 j - 1 之间的最大重复子数组，
    // 而是代表以 A[i - 1] 与 B[j - 1]结尾的公共字串的长度。

    public int findLength(int[] A, int[] B) {
        //注意，不是以 A 的前 i 个元素和 B 的前 j 个元素的公共子数组的最大长度
        // dp[i][j]：数组 A 以 A[i - 1] 这个元素为结尾
        // 数组 B 以 B[j - 1] 这个元素为结尾的子数组的长度
        // 那么 A[i - 1]!= B[j - 1]，dp[i][j]=0;
        // A[i - 1] == B[j - 1]，dp[i][j] = dp[i - 1][j - 1] + 1
        int len1 = A.length;
        int len2 = B.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;

        int res = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
