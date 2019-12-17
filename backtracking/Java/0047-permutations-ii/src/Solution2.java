import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    // 尽量使用成员变量，减少方法参数的传递

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] marked;
    private int[] nums;
    private int n;

    private void findPermuteUnique(int depth, Stack<Integer> stack) {
        if (depth == n) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                if (i != 0 && nums[i] == nums[i - 1] && !marked[i - 1]) {
                    continue;
                }
                marked[i] = true;
                stack.add(nums[i]);
                findPermuteUnique(depth + 1, stack);
                stack.pop();
                marked[i] = false;
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
        marked = new boolean[len];
        findPermuteUnique(0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        // int[] nums = {1, 2, 3};
        int[] nums = {1, 1, 2};
        Solution2 solution2 = new Solution2();
        List<List<Integer>> lists = solution2.permuteUnique(nums);
        System.out.println(lists);
    }
}
