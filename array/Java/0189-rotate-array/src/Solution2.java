import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/10/15 7:03 下午
 */
public class Solution2 {

    // 向右旋转
    // 输入: [1,2,3,4,5,6,7] 和 k = 3

    // 结果：[5,6,7,1,2,3,4]

    // 中间过程：
    // 7 6 5 4 3 2 1
    // 5 6 7 1 2 3 4

    public void rotate(int[] nums, int k) {
        // 先写出极端条件
        int len = nums.length;
        if (len == 0 || k <= 0) {
            return;
        }

        k %= len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int index1, int index2) {
        if (index1 >= index2) {
            return;
        }
        while (index1 < index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
            index1++;
            index2--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution solution = new Solution();
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
