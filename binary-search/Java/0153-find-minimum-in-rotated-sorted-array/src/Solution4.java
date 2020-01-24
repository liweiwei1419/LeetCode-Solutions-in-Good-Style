public class Solution4 {

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        return findMin(nums, 0, len - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        if (left + 1 == right) {
            return Math.min(nums[left], nums[right]);
        }
        int mid = (left + right) >>> 1;

        if (nums[mid] < nums[right]) {
            // 右边是顺序数组，[mid + 1 , right] 这个区间里的元素可以不看
            return Math.min(findMin(nums, left, mid - 1), nums[mid]);
        } else {
            // nums[mid] > nums[right]
            // 左边是顺序数组，[left + 1, mid] 这个区间里的元素可以不看
            return Math.min(nums[left], findMin(nums, mid + 1, right));
        }
    }
}
