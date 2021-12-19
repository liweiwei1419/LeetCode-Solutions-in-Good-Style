public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = searchFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        // 能走到这里，数组中一定存在目标元素
        int lastPosition = searchLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private int searchFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 在 nums[left..right] 里查找 target 第一次出现的元素
        while (left < right) {
            int mid = (left + right) / 2;
            // int mid = left + (right - left) / 2;
            // int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                // 小于一定不是解
                // mid 以及 mid 的左边一定不是目标元素第 1 次出现的位置
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        // 退出循环以后 left 与 right 重合
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int searchLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            // int mid = left + (right - left + 1) / 2;
            // int mid = (left + right + 1) >>> 1;
            if (nums[mid] > target) {
                // 大于一定不是解
                // mid 以及 mid 的右边一定不是目标元素最后一次出现的位置
                // 下一轮搜索的区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索的区间是 [mid..right]
                left = mid;
            }
        }
        // 不用做特殊判断，能执行到这个方法，说明数组中一定存在 target
        return left;
    }
}