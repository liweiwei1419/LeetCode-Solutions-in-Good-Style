import java.util.Arrays;

public class Solution4 {

    // 方法三：记忆化递归
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)

    /**
     * 以 nums[i] 结尾的最长上升子序列的长度
     */
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        // 特判
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        memo = new int[len];
        Arrays.fill(memo, -1);

        int res = 1;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, getMaxLength(nums, i));
        }

        return res;
    }

    private int getMaxLength(int[] nums, int index) {
        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 1;
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index]) {
                res = Math.max(res, 1 + getMaxLength(nums, i));
            }
        }
        return memo[index] = res;
    }
}