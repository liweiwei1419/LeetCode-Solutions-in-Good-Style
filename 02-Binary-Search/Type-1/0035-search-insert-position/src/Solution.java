public class Solution {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 题目没有说输入数组的长度可能为 0，因此需要做特殊判断
        if (len == 0) {
            return 0;
        }

        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0;
        int right = len - 1;

        // 在区间 [left, right] 查找插入元素的位置
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                // 下一轮搜索的区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left, mid]
                right = mid;
            }
        }
        // 由于程序走到这里 [left, right] 里一定存在插入元素的位置
        // 且退出循环的时候一定有 left == right 成立，因此返回 left 或者 right 均可
        return left;
    }
}