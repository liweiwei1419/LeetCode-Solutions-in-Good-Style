import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

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

    private void dfs(int[] nums, int len, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (index == len){
            res.add(new ArrayList<>(path));
            return;
        }

        path.addLast(nums[index]);
        dfs(nums, len, index + 1, path, res);
        path.removeLast();

        dfs(nums, len, index + 1, path, res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = solution.subsets(nums);
        System.out.println(res);
    }
}