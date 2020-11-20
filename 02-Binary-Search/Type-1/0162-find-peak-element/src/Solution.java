public class Solution {

    // 返回任何一个峰值，看相邻位置

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 正好看到的是右边元素，分支排除了左边界，并且使用左中位数，可以保证逻辑是完备的
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 峰值元素一定存在，因此无需后处理
        return left;
    }
}