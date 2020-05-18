import java.util.Arrays;

public class Solution3 {

    // 动态规划解法 2


    public int splitArray(int[] nums, int m) {
        int n = nums.length;

        // prefix sum
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        // DP Table: default Integer.MAX_VALUE
        int[][] dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        // 最后一个 subarray 定义为 [start, end]
        // dp[x][m] = min(for all start < x: max(dp[start - 1][m - 1], pre[x + 1] - pre[start]))
        // 初始化: m = 0 把 array 分成 1 段，dp[n][0] 为 array 的前项和
        for (int start = 0; start < n; start++) {
            dp[0][start] = pre[start + 1];
        }

        // k = split into k + 1 subarrays | k = 切成 k + 1 段
        for (int k = 1; k < m; k++) {
            // 切成 k + 1 段, 最后一个 subarray 结束位置最小值是 k
            for (int end = k; end < n; end++) {
                // 切成 k + 1 段, 最后一个 subarray 开始位置最小值是 k
                for (int start = k; start <= end; start++) {
                    dp[k][end] = Math.min(dp[k][end], Math.max(dp[k - 1][start - 1], (pre[end + 1] - pre[start])));
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}
