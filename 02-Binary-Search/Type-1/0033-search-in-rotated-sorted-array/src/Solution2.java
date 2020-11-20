public class Solution2 {

    // 中间元素和左边界比较

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        // 注意：这里是等于
        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (nums[mid] > nums[left]) {
                // 前有序，包括中间数
                // 1 2 6 7 8 9
                // 6 7 8 9 1 2
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else {
                // 后有序，包括中间数
                // 8 9 1 2 6 7
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}