public class Solution3 {

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空，最小值不存在");
        }
        return findMin(nums, 0, len - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right]);
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;
        return Math.min(findMin(nums, left, mid - 1), findMin(nums, mid, right));
    }
}
