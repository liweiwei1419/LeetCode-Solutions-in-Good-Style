import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Solution6 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        helper(nums, 0, len, res);
        return res;
    }

    private void helper(int[] nums, int index, int len, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList(Collections.singletonList(nums)));
            return;
        }
        // 从 index 的下一位开始一直要交换到最后一位
        for (int i = index; i < len; i++) {
            // System.out.println(Arrays.toString(nums) + " i " + i + " index " + index);
            swap(nums, index, i);
            helper(nums, index + 1, len, res);
            // 注意：递归完成以后要交换回来
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

