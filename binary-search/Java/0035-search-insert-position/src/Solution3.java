/**
 * @author liweiwei1419
 * @date 2019/11/19 4:21 下午
 */
public class Solution3 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = len - 1;

        while (left < right) {
            // 根据分支 1、分支 2、分支 3，选左中位数
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                // 分支 1：mid 的右边一定不是解，下一轮搜索的范围是 [left, mid]
                right = mid;
            } else if (nums[mid] == target) {
                // 分支 2：同上，mid 的右边一定不是解，下一轮搜索的范围是 [left, mid]
                right = mid;
            } else {
                // 分支 3：此时 nums[mid] < target
                // 此时 mid 以及 mid 的左边均严格小于 target，它们一定不是解，
                // 下一轮搜索的范围是 [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }
}
