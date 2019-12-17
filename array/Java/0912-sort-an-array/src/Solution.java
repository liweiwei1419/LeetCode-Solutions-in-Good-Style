import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/9 4:20 下午
 */
public class Solution {

    // 选择排序

    public List<Integer> sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }

        List<Integer> res = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution solution = new Solution();
        List<Integer> res = solution.sortArray(nums);
        System.out.println(res);
    }
}
