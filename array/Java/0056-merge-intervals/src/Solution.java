import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/11/28 2:14 下午
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0][0];
        }

        // 按照起点排序
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < len; i++) {
            if (stack.peek()[1] < intervals[i][0]) {
                stack.push(intervals[i]);
            } else {
                // 更新
                stack.peek()[1] = Math.max(stack.peek()[1], intervals[i][1]);
            }
        }
        return stack.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution solution = new Solution();
        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(intervals[i]));
        }
    }
}
