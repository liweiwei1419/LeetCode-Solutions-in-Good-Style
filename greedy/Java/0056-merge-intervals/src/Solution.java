import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution {

    // 贪心算法，所以一开始要对集合排序
    // 扫描线法

    public int[][] merge(List<Interval> intervals) {
        int len = intervals.size();
        if (len < 2) {
            return new int[0][0];
        }

        intervals.sort(Comparator.comparingInt((Interval a) -> a.start));

        // 因为每次我们都拿最后一个元素，因此用栈是比较方便的
        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for (int i = 1; i < len; i++) {
            Interval curInterval = intervals.get(i);
            Interval peek = stack.peek();
            if (curInterval.start > peek.end) {
                stack.add(curInterval);
            } else {
                // 注意，这里应该取最大
                peek.end = Math.max(curInterval.end, peek.end);
            }
        }
        return stack.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();

        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);

        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);

        Solution solution = new Solution();
        int[][] res = solution.merge(intervals);
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
