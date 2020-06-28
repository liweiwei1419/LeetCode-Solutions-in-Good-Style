public class Solution2 {

    public int findMin(int[] nums) {
        int len = nums.length;
        return findMin(nums, 0, len - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left >= right) {
            return Math.min(nums[left], nums[right]);
        }

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == nums[right]) {
            return findMin(nums, left, right - 1);
        } else if (nums[mid] < nums[right]) {
            return findMin(nums, left, mid);
        } else {
            return findMin(nums, mid + 1, right);
        }
    }
}
