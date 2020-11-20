public class Solution {

    // 比目标字母大的最小字母
    // 小于等于一定不是解，找严格大于 target 的第 1 个位置

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        // 转换为第 35 题：其实就是找插入元素的位置
        // 搜索范围 [0, len]
        int left = 0;
        // 分析这一步特别重要
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                // 下一轮搜索的区间是：[mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 因为有可能不存在
        if (left == len) {
            return letters[0];
        }
        return letters[left];
    }
}
