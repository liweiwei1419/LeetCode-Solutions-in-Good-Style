/**
 * @author liweiwei1419
 * @date 2019/9/19 9:10 下午
 */
public class Solution2 {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int firstPosition = searchFirstPosition(nums, len, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int lastPosition = searchLastPosition(nums, len, target);
        return new int[]{firstPosition, lastPosition};
    }

    private int searchFirstPosition(int[] nums, int len, int target) {
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                // mid 以及 mid 的左边一定不是目标元素第 1 次出现的位置
                // 下一轮搜索的区间是 `[mid + 1, right]`
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 `[left, mid]`
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int searchLastPosition(int[] nums, int len, int target) {
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                // mid 以及 mid 的右边一定不是目标元素最后一次出现的位置
                // 下一轮搜索的区间是 `[left, mid - 1]`
                right = mid - 1;
            } else {
                // 下一轮搜索的区间是 `[mid, right]`
                left = mid;
            }
        }
        return left;
    }
}
