public class Solution5 {

    // 分治法

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("给出的数组为空，没有最小值");
        }
        return findMin(nums, 0, len - 1);
    }

    public int findMin(int[] nums, int left, int right) {
        // 分治的方法，首先先要处理要递归终止的条件
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right]);
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        int mid = (left + right) >>> 1;
        return Math.min(findMin(nums, left, mid), findMin(nums, mid + 1, right));
    }
}
