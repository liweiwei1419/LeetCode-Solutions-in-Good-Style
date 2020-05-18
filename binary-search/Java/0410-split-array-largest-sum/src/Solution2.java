import java.util.Arrays;

public class Solution2 {

    // 动态规划解法 1

    public int splitArray(int[] nums, int m) {
        int len = nums.length;

        int[] pre = new int[len + 1];
        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        // dp[i][j] 表示前 i 个数字，能够凑成的分割数的「子数组各自的和的最大值」
        // 第 2 维由于要保持语义，不做偏移，为此 0 占位，设置 m + 1 长度
        int[][] dp = new int[len][m + 1];

        for (int[] i : dp) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        for (int i = 0; i < len; i++) {
            dp[i][1] = pre[i + 1];
        }

        // i: 枚举的是每一段的结尾的下标
        for (int i = 0; i < len; i++) {
            // j: 枚举的是子数组的个数（单独的一个数字肯定可以是一段，因此从 2 开始枚举）
            for (int j = 2; j <= m; j++) {
                // 枚举每一段的起始位置，发生状态转移
                for (int start = j - 1; start <= i; start++) {
                    // pre[i + 1] - pre[start] 表示区间 nums[start..i] 的和
                    // dp[start - 1][j - 1] 表示枚举到之前的数，少了一段的值
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[start - 1][j - 1], pre[i + 1] - pre[start]));
                }
            }
        }
        return dp[len - 1][m];
    }
}
