import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len < 2) {
            return len;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res = 1;

        // 当前区间的结尾下标
        int end = points[0][1];
        for (int i = 1; i < len; i++) {
            if (points[i][0] > end) {
                res++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return res;
    }
}