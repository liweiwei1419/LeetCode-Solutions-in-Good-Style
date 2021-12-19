public class Solution3 {

    // 「力扣」第 912 题：排序数组：https://leetcode-cn.com/problems/sort-an-array/

    public int[] sortArray(int[] nums) {
        int len = nums.length;

        // 先选出整个数组中最小的元素，将它交换到下标为 0 的位置
        int minIndex = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[minIndex]){
                minIndex = i;
            }
        }
        swap(nums, 0, minIndex);

        // 循环不变量：将 nums[i] 插入到区间 [0..i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int j = i;
            // 省去了 j > 0 这个判断
            while (nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}