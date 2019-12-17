/**
 * @author liweiwei1419
 * @date 2019/9/19 9:10 下午
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int lowerBound = findLowerBound(nums, len, target);
        if (lowerBound == -1) {
            return new int[]{-1, -1};
        }
        int upBound = findUpBound(nums, len, target);
        return new int[]{lowerBound, upBound};
    }

    private int findLowerBound(int[] nums, int len, int target) {
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
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

    private int findUpBound(int[] nums, int len, int target) {
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为先 findLowerBound 才走到这里，保证了 target 一定在 nums 中，因此无需后处理
        return left;
    }
}
