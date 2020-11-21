public class Solution {

    // 方法一：动态规划

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 这里 j 表示左子树的元素个数，最小是 0 ，最大是 i - 1
            // 左边子树 + 右边子树 = i - 1
            // i - j - 1 表示的是右边子树元素个数
            for (int j = 0; j < i; j++) {
                // 使用 * 是因为乘法计数原理
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}