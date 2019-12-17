public class Solution {

    // 典型的例子：
    // [4, 5, 6, 1, 2]
    // [1, 2, 3, 4, 5]
    // 只能使用中间数和右边界比较

    public int findMin(int[] nums) {
        int len = nums.length;
        // 特判
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                // 中间数一定不是"旋转排序数组的最小值"
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 非空数组一定存在最小值，故无需后处理
        return nums[left];
    }
}
