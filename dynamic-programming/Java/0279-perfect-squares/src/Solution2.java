public class Solution2 {


    // 说明 dp[0] = 0; 的合理性
    // 表达式 1 + dp[i - j * j] = 1 ，表示它自己就是一个完全平方式，所以结果是 1

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // dp[1] = 1;

        // 合理
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // int min = Integer.MAX_VALUE;
            int min = n;
            // 这个等于号特别重要，i - j * j 等于 0 的时候，

            for (int j = 1; i - j * j >= 0; j++) {
                min = Math.min(1 + dp[i - j * j], min);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int numSquares = solution2.numSquares(12);
        System.out.println(numSquares);
    }
}
