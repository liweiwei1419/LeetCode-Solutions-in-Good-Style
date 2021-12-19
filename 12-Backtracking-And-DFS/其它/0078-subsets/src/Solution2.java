import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int begin, Deque<Integer> path, List<List<Integer>> res) {
        for (int i = begin; i < len; i++) {
            path.addLast(nums[i]);
            dfs(nums, len, i + 1, path, res);
            path.removeLast();
        }
        res.add(new ArrayList<>(path));
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = solution2.subsets(nums);
        System.out.println(res);
    }
}