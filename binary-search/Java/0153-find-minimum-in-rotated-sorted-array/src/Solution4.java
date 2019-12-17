public class Solution4 {

    // 分治法

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        return findMin(nums, 0, len - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        // 思考：这个临界条件是为什么?
        // 或者写成 left + 1 >= right
        if (left == right || left + 1 == right) {
            return Math.min(nums[left], nums[right]);
        }
        int mid = (left + right) >>> 1;
        // 8 9 1 2 3 4 5 6 7
        if (nums[mid] < nums[right]) {
            // 右边是顺序数组
            return Math.min(findMin(nums, left, mid - 1), nums[mid]);
        } else {
            // 左边是顺序数组
            // nums[mid] > nums[right]
            // 3 4 5 6 7 8 1 2
            return Math.min(nums[left], findMin(nums, mid + 1, right));
        }
    }
}
