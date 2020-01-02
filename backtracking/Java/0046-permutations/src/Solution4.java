import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution4 {

    private int[] nums;
    private int len;
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    /**
     * @param index 表示已经取了 index 个元素构成子排列
     * @param stack     已经得到的有，索引到 index-1 的一个子排列
     */
    private void generatePermutation(int index, Deque<Integer> stack) {
        printUsedArrayAndDepth(index);
        if (index == len) {
            // 此时所有的数字都已经使用完成 stack 已经是一个解了
            // 这里一定要注意，Java 中是引用传递，因此得到一个结果的时候，要重新 new 一个对象
            res.add(new ArrayList<>(stack));
            return;
        }
        // 看看哪些元素还没有被使用过
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                stack.addLast(nums[i]);
                generatePermutation(index + 1, stack);
                // 刚开始接触回溯算法的时候常常会忽略状态重置
                // 回溯的时候，一定要记得状态重置
                stack.removeLast();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        if (len == 0) {
            return res;
        }
        used = new boolean[len];
        generatePermutation(0, new ArrayDeque<>());
        return res;
    }

    private void printUsedArrayAndDepth(int index) {
        StringBuilder s = new StringBuilder();
        s.append(index);
        s.append(": [");
        for (int i = 0; i < len; i++) {
            s.append(used[i] ? 1 : 0);
            if (i != len - 1) {
                s.append(",");
            }
        }
        s.append("]");
        System.out.println(s.toString());
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Solution4().permute(nums);
        System.out.println(lists);
    }
}
