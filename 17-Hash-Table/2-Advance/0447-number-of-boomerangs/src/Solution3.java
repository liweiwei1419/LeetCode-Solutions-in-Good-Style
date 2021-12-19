import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution3 {

    // 超出内存限制，这个解答不采纳

    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        // 得到排列
        List<List<Integer>> permutations = permutation(len, 3);
        int res = 0;
        for (List<Integer> tuple : permutations) {
            if (distance(points[tuple.get(0)], points[tuple.get(1)]) == distance(points[tuple.get(0)], points[tuple.get(2)])) {
                res++;
            }
        }
        return res;
    }

    private int distance(int[] point1, int[] point2) {
        int diffX = point1[0] - point2[0];
        int diffY = point1[1] - point2[1];
        return diffX * diffX + diffY * diffY;
    }

    private List<List<Integer>> permutation(int num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[num];
        boolean[] visited = new boolean[num];
        for (int i = 0; i < num; i++) {
            nums[i] = i;
        }
        Stack<Integer> stack = new Stack<>();
        helper(nums, visited, res, 0, stack, target, num);
        return res;
    }

    private void helper(int[] nums,
                        boolean[] visited,
                        List<List<Integer>> res,
                        int hasUsedNumber,
                        Stack<Integer> pre, int target, int num) {

        if (hasUsedNumber == target) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = 0; i < num; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pre.add(i);
                helper(nums, visited, res, hasUsedNumber + 1, pre, target, num);
                visited[i] = false;
                pre.pop();
            }
        }
    }
}