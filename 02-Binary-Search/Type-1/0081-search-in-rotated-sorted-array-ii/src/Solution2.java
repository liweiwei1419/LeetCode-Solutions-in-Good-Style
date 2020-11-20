public class Solution2 {

    // [2,5,6,0,0,1,2]
    // [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,5,6,0,0,1,2]

    // while (left <= right) 的写法，与右边界比较

    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] < nums[right]) {
                // mid 到 right 是顺序数组
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // nums[mid] > nums[right]
                // left 到 mid 是顺序数组
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}