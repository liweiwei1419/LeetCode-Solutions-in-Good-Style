public class Solution {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return 0;
        }

        int lastPosition = findLastPosition(nums, target);
        return lastPosition - firstPosition + 1;
    }

    private int findLastPosition(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {

            // 注意，以下 nums[mid] < target 以及 nums[mid] == target 的情况可以合并
            // 边界是 left = mid ，取中间数的时候必须 + 1
            int mid = (left + right + 1) >>> 1;

            if (nums[mid] < target) {
                // mid 以及 mid 左边都不是，下一轮搜索区间在 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // mid 可能是，mid 左边一定不是，下一轮搜索区间在 [mid, right]
                left = mid;
            } else {
                // 此时 nums[mid] > target
                // mid 以及 mid 右边都不是，下一轮搜索区间在 [left, mid - 1]
                right = mid - 1;
            }
        }


        return left;
    }

    private int findFirstPosition(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] < target) {
                // mid 以及 mid 左边都不是，下一轮搜索区间在 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // mid 可能是，mid 右边一定不是，下一轮搜索区间在 [left, mid]
                right = mid;
            } else {
                // 此时 nums[mid] > target
                // mid 以及 mid 右边都不是，下一轮搜索区间在 [left, mid - 1]
                right = mid - 1;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
