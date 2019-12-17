import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liweiwei1419
 * @date 2019/12/3 3:40 下午
 */
public class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildingPoints = new ArrayList<>();
        for (int[] b : buildings) {
            buildingPoints.add(new int[]{b[0], -b[2]});
            buildingPoints.add(new int[]{b[1], b[2]});
        }
        buildingPoints.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0);
        int preMax = 0;
        for (int[] bp : buildingPoints) {
            if (bp[1] < 0) {
                maxHeap.offer(-bp[1]);
            } else {
                maxHeap.remove(bp[1]);
            }
            int curHeight = maxHeap.peek();
            if (curHeight != preMax) {
                List<Integer> temp = new ArrayList<>(2);
                temp.add(bp[0]);
                temp.add(curHeight);
                res.add(temp);
                preMax = curHeight;
            }
        }
        return res;
    }
}
