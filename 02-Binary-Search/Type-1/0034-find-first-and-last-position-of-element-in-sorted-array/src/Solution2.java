public class Solution2 {

    // left < right 分三个模块来写

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }


    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // 不可以直接返回，应该继续向左边找，同时保留 mid，因为它可能是第 1 次出现的位置，即 [left, mid] 区间里找
                right = mid;
            } else if (nums[mid] < target) {
                // 应该继续向右边找，即 [mid + 1, right] 区间里找
                left = mid + 1;
            } else {
                // 此时 nums[mid] > target，应该继续向左边找，即 [left, mid - 1] 区间里找
                right = mid - 1;
            }
        }

        // 此时 left 和 right 的位置关系是 right == left，但有可能不存在，因此还需要特别做一次判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // 注意：需要调整为上取整
            int mid = left + (right - left + 1) / 2;

            if (nums[mid] == target) {
                // 不可以直接返回，应该继续向右边找，同时 mid 可能是最后一次出现的位置，即 [mid, right] 区间里找
                left = mid;
            } else if (nums[mid] < target) {
                // 应该继续向右边找，即 [mid + 1, right] 区间里找
                left = mid + 1;
            } else {
                // 此时 nums[mid] > target，应该继续向左边找，即 [left, mid - 1] 区间里找
                right = mid - 1;
            }
        }
        return left;
    }
}