public class Solution2 {

    // 注意数组中可能存在重复的元素。
    // 也可以得到一个 AC 解

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空，不存在最小元素");
        }
        return findMin(nums, 0, len - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left >= right) {
            return Math.min(nums[left], nums[right]);
        }

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        int mid = (left + right) >>> 1;
        if (nums[mid] == nums[right]) {
            return Math.min(findMin(nums, left, mid), findMin(nums, mid + 1, right));
        } else if (nums[mid] < nums[right]) {
            // 5 6 1 2 3 4 5
            return findMin(nums, left, mid);
        } else {
            // 5 6 7 8 9 1 2
            return findMin(nums, mid + 1, right);
        }
    }
}
