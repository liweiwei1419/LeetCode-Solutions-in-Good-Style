public class Solution {

    // 从 [1, W] 的范围中随机获得一个整数作为分数进行累计
    // 不少于 K 分时，她就停止抽取数字

    // 爱丽丝的分数不超过 N 的概率是多少？

    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + W + 1];

        // dp[x]：Alice 获得的 i 点的概率
        // dp[k] = 1.0 when K <= k <= N, else 0.0
        for (int k = K; k <= N; ++k) {
            dp[k] = 1.0;
        }

        double S = Math.min(N - K + 1, W);
        // S = dp[k + 1] + dp[k + 2] + ... + dp[k + W]
        for (int k = K - 1; k >= 0; --k) {
            dp[k] = S / W;
            S += dp[k] - dp[k + W];
        }
        return dp[0];
    }
}
