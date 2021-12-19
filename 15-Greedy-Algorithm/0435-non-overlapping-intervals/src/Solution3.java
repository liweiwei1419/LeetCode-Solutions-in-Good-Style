import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {

    // 贪心算法：最先结束的区间，一定是最优解的一部分

    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        // 计算哪些区间被丢弃
        int res = 0;
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] < end) {
                res++;
            } else {
                end = intervals[i][1];
            }
        }
        return res;
    }
}