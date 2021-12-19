import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
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
}
