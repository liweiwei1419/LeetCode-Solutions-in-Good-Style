public class Solution {

    // 中间的数与右边界比较

    public boolean search(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[right]) {
                // 具体例子：[10, 11, 4, 5, 6, 7, 8, 9]，mid 右边的一定是顺序数组，包括 nums[mid]
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                // 具体例子：[4, 5, 9, 2]，mid 左边是一定是顺序数组，包括 nums[mid]
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else {
                if (nums[right] == target) {
                    return true;
                }
                right = right - 1;
            }
        }
        return nums[left] == target;
    }
}