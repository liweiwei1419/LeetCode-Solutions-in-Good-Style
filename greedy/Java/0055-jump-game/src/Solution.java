import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/10/14 2:09 下午
 */
public class Solution {

    /**
     * 最原始的想法，按照题意给出的
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return false;
        }
        boolean[] reach = new boolean[len];
        reach[0] = true;
        for (int i = 0; i < len; i++) {
            int maxReach = Math.min(len - 1, i + nums[i]);
            if (!reach[i]) {
                return false;
            }
            for (int j = i + 1; j <= maxReach; j++) {
                reach[j] = true;
            }
        }
        return reach[len - 1];
    }

    public static void main(String[] args) {
        // int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        Solution solution = new Solution();
        boolean res = solution.canJump(nums);
        System.out.println(res);
    }
}
