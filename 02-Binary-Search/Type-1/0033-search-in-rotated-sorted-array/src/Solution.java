public class Solution {

    // 选择中位数和右边界元素比较，其实跟左边界元素比较也是可以的

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            // 根据分支的逻辑将中位数改成右中位数
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[right]) {
                // 先写落在有序数组区间里的情况
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else {
                // 先写落在有序数组区间里的情况
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}