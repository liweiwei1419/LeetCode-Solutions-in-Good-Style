public class Solution4 {

    // 分治法

    public int findMin(int[] nums) {
        int len = nums.length;
        return findMin(nums, 0, len - 1);
    }

    public int findMin(int[] nums, int left, int right) {
        // 分治的方法，首先先要处理要递归终止的条件
        if (left == right){
            return nums[left];
        }
        if (left + 1 == right) {
            return Math.min(nums[left], nums[right]);
        }

        // 这一步是关键
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        return Math.min(findMin(nums, left, mid), findMin(nums, mid + 1, right));
    }
}
