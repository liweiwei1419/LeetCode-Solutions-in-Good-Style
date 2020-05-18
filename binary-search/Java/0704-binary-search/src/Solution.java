public class Solution {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        // 在 [left, right] 范围里查找目标元素
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 由数组的有序性可知，mid 以及 mid 的左边都小等于 target
                // 下一轮搜索的范围是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 此时 target < nums[mid]
                // 由数组的有序性可知，mid 以及 mid 的右边边都小等于 target
                // 下一轮搜索的范围是 [left, mid - 1]
                right = mid - 1;
            }
        }
        return -1;
    }
}
