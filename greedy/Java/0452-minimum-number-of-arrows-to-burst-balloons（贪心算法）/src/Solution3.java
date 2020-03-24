import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len < 2) {
            return len;
        }

        // 按照区间终点进行排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] != point2[1]) {
                    return point1[1] - point2[1];
                }
                return point1[0] - point2[0];
            }
        });

        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < len; i++) {
            if (points[i][0] > end) {
                // 就得多用一支箭
                end = points[i][1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Solution3 solution2 = new Solution3();
        int minArrowShots = solution2.findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
}
