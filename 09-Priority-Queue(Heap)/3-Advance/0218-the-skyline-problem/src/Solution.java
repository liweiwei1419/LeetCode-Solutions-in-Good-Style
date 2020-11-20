import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    // 参考资料没有找到，这题当做例题来做

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();

        // 预处理
        List<int[]> buildingPoints = new ArrayList<>();
        for (int[] b : buildings) {
            // 负号表示左边线段的端点
            buildingPoints.add(new int[]{b[0], -b[2]});
            buildingPoints.add(new int[]{b[1], b[2]});
        }

        // 按照左端点的横坐标排序
        buildingPoints.sort((a, b) -> {
            if (a[0] != b[0]) {
                // 左端点升序排序
                return a[0] - b[0];
            } else {
                // 如果左端点的横坐标相等，按照右端点的纵坐标升序排序
                // 降序，负负得正
                return a[1] - b[1];
            }
        });

        // 堆顶表示当前「画笔」停留在哪一个高度
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0);
        int lastHeight = 0;
        for (int[] bp : buildingPoints) {
            if (bp[1] < 0) {
                maxHeap.offer(-bp[1]);
            } else {
                // 这个操作是线性的
                maxHeap.remove(bp[1]);
            }
            int curHeight = maxHeap.peek();

            // 当前最高的高度，只要不一样，大于或者小于，只要有高度差，就会有 keypoint 出现
            if (curHeight != lastHeight) {
                // 正在扫过的左端点的值
                res.add(Arrays.asList(bp[0], curHeight));
                // 之前停留的高度
                lastHeight = curHeight;
            }
        }
        return res;
    }
}