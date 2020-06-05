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

    private int findFirstPosition(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 注意这样写，可以从左边收缩待搜索区间的范围，进而找到第一次出现的位置
            if (nums[mid] < target) {
                // mid 以及 mid 左边都不是，下一轮搜索区间在 [mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 注意这样写，可以从右边收缩待搜索区间的范围，进而找到最后一次出现的位置
            if (nums[mid] > target) {
                // mid 以及 mid 右边都不是，下一轮搜索区间在 [left, mid - 1]
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
