import java.util.Arrays;

public class Solution {

    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        // 特判
        if (len < 2) {
            return len;
        }

        // 特别注意：当区间左端点相同的时候，按照右端点降序排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o2[0];
            }
            return o1[0] - o2[0];
        });

        // 需要被删除的区间个数
        int remove = 0;
        int currentRight = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][1] <= currentRight) {
                remove++;
            } else {
                currentRight = intervals[i][1];
            }
        }
        return len - remove;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        Solution solution = new Solution();
        int res = solution.removeCoveredIntervals(intervals);
        System.out.println(res);
    }
}
