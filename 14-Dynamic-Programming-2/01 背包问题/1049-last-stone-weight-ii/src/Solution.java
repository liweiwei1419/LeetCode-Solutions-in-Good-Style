import java.util.Arrays;

public class Solution {

    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = Arrays.stream(stones).sum();

        int target = sum / 2;

        // dp[i][j] 表示：从输入数组的前缀区间 [0..i] 里取出一部分元素，并且和小于等于 j 的最大值
        int[][] dp = new int[len][target + 1];
        // 初始化
        for (int j = stones[0]; j <= target; j++) {
            dp[0][j] = stones[0];
        }
        // 递推开始
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (stones[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 状态转移方程：注意分析这里为什么取最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        // dp[len - 1][target] 最大，整体就最小
        return sum - 2 * dp[len - 1][target];
    }
}