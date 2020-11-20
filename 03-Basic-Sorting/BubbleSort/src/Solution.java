public class Solution {

    // 冒泡排序（基础版）：超时

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            // 只要发生一次交换，就必须进行下一轮比较，
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}