import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution7 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
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

        // key 为元素，value 为高度出现的次数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 1);
        int lastHeight = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int[] buildingPoint : buildingPoints) {
            if (buildingPoint[1] < 0) {
                treeMap.put(-buildingPoint[1], treeMap.getOrDefault(-buildingPoint[1], 0) + 1);
            } else {
                treeMap.put(buildingPoint[1], treeMap.get(buildingPoint[1]) - 1);
            }

            while (true) {
                int curHeight = treeMap.lastEntry().getKey();
                int times = treeMap.lastEntry().getValue();
                if (times == 0) {
                    treeMap.remove(curHeight);
                } else {
                    break;
                }
            }

            int curHeight = treeMap.lastKey();
            if (curHeight != lastHeight) {
                res.add(Arrays.asList(buildingPoint[0], curHeight));
                lastHeight = curHeight;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[][] buildings = new int[][]{{0, 2, 3}, {2, 5, 3}};
        List<List<Integer>> res = solution7.getSkyline(buildings);
        System.out.println(res);
    }
}