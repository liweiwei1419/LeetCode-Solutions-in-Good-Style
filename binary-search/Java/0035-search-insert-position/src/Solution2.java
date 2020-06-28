public class Solution2 {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 找 >= target 的第 1 个数
            if (nums[mid] < target) {
                // 下一轮搜索的区间 [mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
