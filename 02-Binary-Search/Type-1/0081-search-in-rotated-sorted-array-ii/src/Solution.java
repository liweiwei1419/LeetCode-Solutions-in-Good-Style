public class Solution {

    // 中间的数与右边界比较

    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right + 1 ) >>> 1;
            if (nums[mid] < nums[right]) {
                // 10 11 4 5 6 7 8 9
                // 右边的一定是顺序数组，包括中间数
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                // 4 5 9  2
                // 左边是一定是顺序数组，包括中间数
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }else {
                if(nums[right] == target){
                    return true;
                }
                right = right -1;
            }
        }
        return nums[left] == target;
    }
}