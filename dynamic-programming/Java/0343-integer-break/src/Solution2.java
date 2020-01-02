public class Solution2 {

    // 动态规划
    // dp[i] 就是题目问的那种情况
    // 把状态和状态转移方程写清楚，贪心算法的证明过于复杂

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        Solution2 solution2 = new Solution2();

        int res = solution2.integerBreak(n);
        System.out.println(res);

    }
}
