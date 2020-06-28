public class Solution3 {

    // 分治算法

    public int findMin(int[] nums) {
        int len = nums.length;

        return findMin(nums, 0, len - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        if (left + 1 == right) {
            return Math.min(nums[left], nums[right]);
        }
        int mid = left + (right - left) / 2;

        if (nums[mid] < nums[right]) {
            // 右边是顺序数组，[mid + 1 , right] 这个区间里的元素可以不看
            return findMin(nums, left, mid);
        } else {
            // nums[mid] > nums[right]
            // 左边是顺序数组，[left + 1, mid] 这个区间里的元素可以不看
            return findMin(nums, mid + 1, right);
        }
    }
}
