/**
 * @author liweiwei1419
 * @date 2019/11/19 4:06 下午
 */
public class Solution2 {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        // len - 1 的下一位也有可能是插入的位置，因此右边界设置为 len
        int right = len;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                // 分支 1：mid 右边（不包含 mid）一定不是解，因此下一轮搜索的范围是 [left, mid]
                right = mid;
            } else if (nums[mid] < target) {
                // 分支 2：mid 左边（包含 mid）一定不是解，因此下一轮搜索的范围是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 分支 3： nums[mid] > target
                // mid 右边（不包含 mid）一定不是解，因此下一轮搜索的范围是 [left, mid]
                // 可以合并到分支 1
                right = mid;
            }
        }
        return left;
    }
}
