import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        int len = intervals.size();

        // 之前的加起来
        int i = 0;
        while (i < len && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }

        // intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        // 此时 intervals.get(i).end >= newInterval.start
        while (i < len && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }

        res.add(newInterval);

        // 把剩下的加掉
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
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

        Solution2 solution2 = new Solution2();
        Interval newInterval = new Interval(4, 8);
        List<Interval> list = solution2.insert(intervals, newInterval);
        for (Interval interval : list) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
