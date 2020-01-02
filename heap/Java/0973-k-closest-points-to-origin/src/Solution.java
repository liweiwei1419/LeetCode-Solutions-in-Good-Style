import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        if (len == 0) {
            return new int[0][0];
        }

        int[][] res = new int[K][2];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K + 1, (point1, point2) -> (point2[0] * point2[0] + point2[1] * point2[1])
                - (point1[0] * point1[0] + point1[1] * point1[1]));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        for (int i = 0; i < K; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int K = 1;
        Solution solution = new Solution();
        int[][] res = solution.kClosest(points, K);
        System.out.println(Arrays.deepToString(res));
    }
}
