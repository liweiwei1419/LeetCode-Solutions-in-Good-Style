import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // 基于交换的写法

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        dfs(nums, 0, len, res);
        return res;
    }

    private void dfs(int[] nums, int begin, int len, List<List<Integer>> res) {
        if (begin == len) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                temp.add(nums[i]);
            }
            res.add(temp);
            return;
        }
        for (int i = begin; i < len; i++) {
            swap(nums, begin, i);
            dfs(nums, begin + 1, len, res);
            swap(nums, begin, i);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}