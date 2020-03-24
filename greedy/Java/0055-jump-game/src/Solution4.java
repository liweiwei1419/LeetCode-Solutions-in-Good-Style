/**
 * @author liweiwei1419
 * @date 2019/11/28 9:23 下午
 */
public class Solution4 {

    // 贪心算法

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}
