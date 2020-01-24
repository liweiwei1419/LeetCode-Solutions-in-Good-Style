public class Solution2 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        // 乘法因子的单位是 1
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i / 2; j++) {
                dp[i] += 2 * (dp[j] * dp[i - j - 1]);
            }
            if ((i & 1) == 1) {
                dp[i] += dp[i / 2] * dp[i / 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int n = 3;
        int numTrees = solution3.numTrees(n);
        System.out.println(numTrees);
    }
}
