import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // 时间复杂度：O(N^2)，包括了排序的时间复杂度 O(NlogN)

    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        // 特判
        if (len < 2) {
            return 0;
        }

        // 按照起始端点排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 转化为最长上升子序列问题
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return len - res ;
    }
}