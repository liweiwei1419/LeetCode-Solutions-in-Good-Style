/**
 * @author liweiwei1419
 * @date 2019/11/28 9:23 下午
 */
public class Solution5 {

    // 动态规划
    // [2, 3, 1, 1, 4]
    // dp[i]：[0, i - 1] 这个区间里的元素跳到 nums[i] 的时候还能再跳几格

    // 只要能遍历到最后一格就 ok

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }
        return true;
    }


}
