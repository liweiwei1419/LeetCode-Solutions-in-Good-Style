import java.util.PriorityQueue;

public class Solution {

    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        if (len == 0) {
            return new int[0][0];
        }

        // 第 1 步：使用优先队列，动态添加点，lambda 表达式用欧式距离计算点到原点的距离
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K + 1,
                (point1, point2) ->
                        (point2[0] * point2[0] + point2[1] * point2[1]) - (point1[0] * point1[0] + point1[1] * point1[1]));
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        // 第 2 步：将优先队列中的元素输出到结果集列表
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}