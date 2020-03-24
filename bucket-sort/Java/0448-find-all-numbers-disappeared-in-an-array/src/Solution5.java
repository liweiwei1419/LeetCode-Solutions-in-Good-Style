import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/11 11:53 上午
 */
public class Solution5 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        // 3 应该在索引为 2 的位置上
        // nums[i] 应该在 nums[i] - 1 位置上
        for (int i = 0; i < len; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != (i + 1)) {
                res.add((i + 1));
            }
        }
        return res;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Solution solution = new Solution();
        List<Integer> res = solution.findDisappearedNumbers(nums);
        System.out.println(res);
    }
}
