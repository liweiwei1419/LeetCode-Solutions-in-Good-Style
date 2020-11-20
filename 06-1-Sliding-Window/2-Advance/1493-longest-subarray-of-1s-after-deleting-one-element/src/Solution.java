public class Solution {

    // 滑动窗口（暴力解法的优化）

    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;

        // 连续的 1 的个数
        int ones = 0;

        // 删除一个元素以后全为 1 的最长的子串的长度
        int maxCount = 0;
        int res = 0;

        while (right < len) {
            if (nums[right] == 1) {
                ones++;
            }
            maxCount = Math.max(maxCount, ones);
            right++;
            // maxCount + 1 里的 1 就表示删除的那个元素
            while (right - left > maxCount + 1) {
                if (nums[left] == 1) {
                    ones--;
                }
                left++;
            }
            res = Math.max(res, right - left);
        }
        // 注意：这里返回 res 要减 1
        return res - 1;
    }
}