public class Solution2 {

    // 前缀和优化
    // dp[i] 表示分数为 i 的时候的概率
    // 转移的时候枚举此次得分为 j , 其中 1 <= j <= W
    // 注意到两个限制 i - j < K 且 i - j >= 0 即可然后利用

    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + 1];
        double[] preSum = new double[N + 1];

        double res = 0.00;
        dp[0] = 1.00;
        preSum[0] = 1.00;
        for (int i = 1; i <= N; ++i) {
            int left = Math.max(0, i - W);
            int right = Math.min(i - 1, K - 1);
            if (left <= right) {
                if (left == 0) {
                    dp[i] = preSum[right] / (1.0 * W);
                } else {
                    dp[i] = (preSum[right] - preSum[left - 1]) / (1.0 * W);
                }
            }
            preSum[i] = preSum[i - 1] + dp[i];
        }

        for (int i = K; i <= N; ++i) {
            res += dp[i];
        }
        return res;
    }
}
