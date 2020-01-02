import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution9 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        dfs(nums, 0, len, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, int len, Deque<Integer> stack, List<List<Integer>> res) {
        res.add(new ArrayList<>(stack));
        for (int i = start; i < len; i++) {
            stack.push(nums[i]);
            dfs(nums,i + 1,len,stack,res);
            stack.pop();
        }
    }
}
