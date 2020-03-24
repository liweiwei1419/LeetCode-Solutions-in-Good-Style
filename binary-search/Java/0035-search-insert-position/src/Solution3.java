public class Solution3 {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 当 nums[mid] 严格小于目标元素时，不是解
            if (nums[mid] < target) {
                // 下一轮搜索的区间 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
