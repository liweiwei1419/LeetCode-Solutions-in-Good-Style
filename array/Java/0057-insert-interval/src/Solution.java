import java.util.*;

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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
        if (len == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        intervals.add(newInterval);

        // intervals.sort((Interval a, Interval b) -> a.start - b.start);
        intervals.sort(Comparator.comparingInt((Interval i) -> i.start));
        Stack<Interval> stack = new Stack<>();
        stack.add(intervals.get(0));

        for (int i = 1; i <= len; i++) {
            Interval peekInterval = stack.peek();
            Interval curInterval = intervals.get(i);
            if (peekInterval.end < curInterval.start) {
                // [1,3] [4,6] 这种情况，无论如何也合并不了的
                stack.add(curInterval);
            } else {
                // [1,3][3,5]
                // [1,3][2,6]
                // 这两种情况就需要合并
                peekInterval.end = Math.max(curInterval.end, peekInterval.end);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        // intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(3, 5);
        Interval interval3 = new Interval(6, 7);
        Interval interval4 = new Interval(8, 10);
        Interval interval5 = new Interval(12, 16);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval5);

        Solution solution = new Solution();
        Interval newInterval = new Interval(4, 8);
        List<Interval> list = solution.insert(intervals, newInterval);
        for (Interval interval : list) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
