public class Solution2 {

    // 方法二：动态规划（空间优化）

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int continuousIncreasingLen = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                continuousIncreasingLen += 1;
            } else {
                continuousIncreasingLen = 1;
            }

            res = Math.max(res, continuousIncreasingLen);
        }
        return res;
    }
}