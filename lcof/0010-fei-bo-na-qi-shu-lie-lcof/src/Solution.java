public class Solution {

    // 1 1 2 3 5 8
    // 0 1 2 3 4 5
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % (10_0000_0000 + 7);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int fibonacci = solution.fib(48);
        System.out.println(fibonacci);
    }
}
