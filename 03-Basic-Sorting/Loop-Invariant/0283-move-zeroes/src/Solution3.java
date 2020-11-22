public class Solution3 {

    // 循环不变式：
    // [0, notZero] 非零
    // (Zero, i) == 0
    // i == len 时停止

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int notZero = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                notZero++;
                swap(nums, notZero, i);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}