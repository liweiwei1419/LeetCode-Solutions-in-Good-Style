public class Solution2 {

    // 「力扣」第 912 题：排序数组
    // 链接：https://leetcode-cn.com/problems/sort-an-array/

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0..i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前数值严格小于 temp 的所有元素逐个后移
            int temp = nums[i];
            int j = i;
            // 注意边界 j > 0
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }

            // 最后这一步容易忽略
            nums[j] = temp;
        }
        return nums;
    }
}
