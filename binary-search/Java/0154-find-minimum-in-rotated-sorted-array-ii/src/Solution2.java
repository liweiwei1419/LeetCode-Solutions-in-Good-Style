public class Solution2 {

    public int findMin(int[] nums) {
        int len = nums.length;
        return findMin(nums, 0, len - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        // 递归终止条件，区间里只有 1 个元素的时候，返回这个元素
        if (left == right) {
            return nums[left];
        }
        if (left + 1 == right) {
            return Math.min(nums[left], nums[right]);
        }

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        // 分治：设置分治的界限
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
