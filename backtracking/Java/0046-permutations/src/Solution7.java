import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution7 {

    // Recursive get all the permutations in place
    // 时间复杂度: O(n!)
    // 空间复杂度: O(n)

    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        generatePermutation(nums, 0);

        return res;
    }

    private void generatePermutation(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList(Collections.singletonList(nums)));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, index);
            generatePermutation(nums, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
