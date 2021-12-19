import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class Solution2 {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // 记录当前区间的最远点
        Deque<int[]> stack = new ArrayDeque<>();
        stack.add(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] top = stack.peekLast();

            if (intervals[i][0] > top[1]) {
                stack.addLast(intervals[i]);
            } else {
                // top[1] >= intervals[i][0]
                // 说明有交集
                top[1] = Math.max(top[1], intervals[i][1]);
            }
        }

        int size = stack.size();
        int[][] res = new int[size][];

        for (int i = 0; i < size; i++) {
            res[i] = stack.pollFirst();
        }
        return res;
    }
}