public class Solution3 {

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空，不存在最小值");
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                // 右边是顺序数组
                // 6 7 1 2 3
                right = mid;
            } else {
                // 左边是顺序数组
                // 5 6 7 8 9 1 2
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
