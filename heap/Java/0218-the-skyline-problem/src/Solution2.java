import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildLines = new ArrayList<>();

        // building 格式：横坐标、纵坐标、高度
        for (int[] building : buildings) {
            buildLines.add(new int[]{building[0], -building[2]});
            buildLines.add(new int[]{building[1], building[2]});
        }

        // 按横坐标升序排序，扫描线法
        Collections.sort(buildLines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }

                // 在横坐标相等的时候，按照高度升序排序
                return o1[1] - o2[1];
            }
        });


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxHeap.offer(0);

        int preHeight = 0;

        for (int[] buildLine : buildLines) {
            if (buildLine[1] < 0) {
                maxHeap.offer(-buildLine[1]);
            } else {
                maxHeap.remove(buildLine[1]);
            }

            int curHeight = maxHeap.peek();
            if (curHeight != preHeight) {
                res.add(Arrays.asList(buildLine[0], curHeight));
                preHeight = curHeight;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.getSkyline(buildings);
        System.out.println(res);
    }
}