public class Solution {

    // 哨兵写法

    // i,j 的值来源：上面和前面的值之和

    // 语义清晰，但是空间可以只用一行

    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        // 第 1 行（行索引为 0）只能沿着边缘走
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 第 1 列（列索引为 0）只能沿着边缘走
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // 输入: m = 7, n = 3
        // 输出: 28
        Solution solution = new Solution();
        int m = 7;
        int n = 3;
        int uniquePaths = solution.uniquePaths(m, n);
        System.out.println(uniquePaths);
    }
}
