import java.util.Map;
import java.util.TreeMap;

public class Solution2 {

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0];
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            treeMap.put(intervals[i][0], i);
        }
        for (int i = 0; i < len; i++) {
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i][1]);
            if (entry == null) {
                res[i] = -1;
            } else {
                res[i] = entry.getValue();
            }
        }
        return res;
    }
}