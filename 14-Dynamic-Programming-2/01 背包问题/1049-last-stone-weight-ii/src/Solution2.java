import java.util.Arrays;

public class Solution2 {

    // 避免初始化的写法

    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[][] dp = new int[len + 1][target + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= target; j++) {
                if (stones[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return sum - 2 * dp[len][target];
    }
}