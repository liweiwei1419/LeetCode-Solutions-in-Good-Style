import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;
    private int[] nums;
    private int n;

    private void findPermuteUnique(int depth, Deque<Integer> stack) {
        if (depth == n) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.add(nums[i]);
                findPermuteUnique(depth + 1, stack);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        n = len;
        Arrays.sort(nums);
        this.nums = nums;
        used = new boolean[len];
        findPermuteUnique(0, new ArrayDeque<>());
        return res;
    }
}
