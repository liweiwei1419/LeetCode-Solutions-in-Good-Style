import java.util.Arrays;

public class Solution {

    // 方法一：动态规划（参考官方题解）

    public int racecar(int target) {
        int[] dp = new int[target + 3];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 4;

        for (int t = 3; t <= target; ++t) {
            // 前导 0：无符号整型i的最高非零位前面的0的个数，包括符号位在内；
            int k = 32 - Integer.numberOfLeadingZeros(t);
            if (t == (1 << k) - 1) {
                dp[t] = k;
                continue;
            }
            for (int j = 0; j < k - 1; ++j) {
                dp[t] = Math.min(dp[t], dp[t - (1 << (k - 1)) + (1 << j)] + k - 1 + j + 2);
            }
            if ((1 << k) - 1 - t < t) {
                dp[t] = Math.min(dp[t], dp[(1 << k) - 1 - t] + k + 1);
            }
        }

        return dp[target];
    }

}

