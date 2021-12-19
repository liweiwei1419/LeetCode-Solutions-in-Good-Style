import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution5 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Integer> boundaries = new ArrayList<>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);


        int len = buildings.length;
        int index = 0;
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int boundary : boundaries) {
            while (index < len && buildings[index][0] <= boundary) {
                pq.offer(new int[]{buildings[index][1], buildings[index][2]});
                index++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }

            int maxn = pq.isEmpty() ? 0 : pq.peek()[1];
            if (res.size() == 0 || maxn != res.get(res.size() - 1).get(1)) {
                res.add(Arrays.asList(boundary, maxn));
            }
        }
        return res;
    }

}
