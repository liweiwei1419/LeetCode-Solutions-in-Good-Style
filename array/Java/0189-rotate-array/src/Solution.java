import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/10/8 4:29 下午
 */
public class Solution {

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        // [1,2,3,4,5,6,7] 向右旋转 7 位也是一样的
        if (len == 0 || k % len == 0) {
            return;
        }

        k = k % len;

        // 前 len - k 位反转
        // 后 k 位反转
        // 整体反转
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution solution = new Solution();
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
