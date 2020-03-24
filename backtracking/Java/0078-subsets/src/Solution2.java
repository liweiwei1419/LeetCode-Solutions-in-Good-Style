import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, len, path, res);
        return res;
    }

    /**
     * @param nums
     * @param begin
     * @param len
     * @param path
     * @param res
     */
    private void dfs(int[] nums, int begin, int len, Deque<Integer> path, List<List<Integer>> res) {
        // 在遍历的过程中，收集符合条件的结果
        res.add(new ArrayList<>(path));
        for (int i = begin; i < len; i++) {
            path.addLast(nums[i]);
            dfs(nums, i + 1, len, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = solution2.subsets(nums);
        System.out.println(res);
    }
}
