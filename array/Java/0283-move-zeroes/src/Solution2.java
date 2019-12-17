/**
 * @author liweiwei1419
 * @date 2019/10/13 2:25 上午
 */
public class Solution2 {

    // 循环不变式：
    // [0, notZero) 非零
    // [Zero, i) == 0
    // i == len

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        int notZero = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                swap(nums, notZero, i);
                notZero++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
