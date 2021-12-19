import java.util.Arrays;

public class Solution3 {

    // 空间优化的写法

    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = Arrays.stream(stones).sum();

        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int j = stones[0]; j <= target; j++) {
            dp[j] = stones[0];
        }

        // 递推开始
        for (int i = 1; i < len; i++) {
            // 注意：这里 j--
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}