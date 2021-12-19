import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {

    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len < 2) {
            return len;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int end = points[0][1];
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                res++;
            }
        }
        return res;
    }
}