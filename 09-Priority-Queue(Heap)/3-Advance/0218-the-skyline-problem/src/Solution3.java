import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Solution3 {

    // 不可以用二叉搜索树的原因是：相同的 key 在二叉搜索树中会被覆盖

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> buildLines = new ArrayList<>();
        // building 格式：横坐标、纵坐标、高度
        for (int[] building : buildings) {
            buildLines.add(new int[]{building[0], -building[2]});
            buildLines.add(new int[]{building[1], building[2]});
        }

        // 按横坐标升序排序，扫描线法
        buildLines.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            // 在横坐标相等的时候，按照高度升序排序
            return o1[1] - o2[1];
        });


        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        int preHeight = 0;

        List<List<Integer>> res = new ArrayList<>();
        for (int[] buildLine : buildLines) {
            if (buildLine[1] < 0) {
                treeSet.add(-buildLine[1]);
            } else {
                treeSet.remove(buildLine[1]);
            }

            int curHeight = treeSet.last();
            System.out.println(treeSet);
            System.out.println(treeSet.last());

            if (curHeight != preHeight) {
                res.add(Arrays.asList(buildLine[0], curHeight));
                preHeight = curHeight;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][]{{0, 2147483647, 2147483647}};
        // int[][] buildings = new int[][]{{0, 2, 3}, {2, 5, 3}};
        Solution3 solution3 = new Solution3();
        List<List<Integer>> res = solution3.getSkyline(buildings);
        System.out.println(res);
    }
}