public class Solution {

    // 「力扣」第 704 题：二分查找
    // 地址：https://leetcode-cn.com/problems/binary-search/

    public int search(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        // 目标元素可能存在在区间 [left, right]
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 目标元素可能存在在区间 [mid + 1, right]
                left = mid + 1;
            } else {
                // 目标元素可能存在在区间 [left, mid - 1]
                right = mid - 1;
            }
        }
        return -1;
    }
}
