public class Solution2 {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        // 注意：这里初始值设置为 len，表示 len 这个下标也有可能是插入元素的位置
        int right = len;
        // 在区间 [left..right] 查找插入元素的位置
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 找 >= target 的第 1 个数
            if (nums[mid] < target) {
                // 下一轮搜索的区间 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        // 由于程序走到这里 [left..right] 里一定存在插入元素的位置
        // 且退出循环的时候一定有 left == right 成立，因此返回 left 或者 right 均可
        return left;
    }
}