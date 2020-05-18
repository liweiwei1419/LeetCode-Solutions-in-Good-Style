import java.util.Arrays;

public class Solution {


    // 递归（有很多重复子问题）

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int[] reached = new int[len];
        Arrays.fill(reached, -1);
        reached[0] = 1;
        canJumpFromPosition(nums, 0, reached);
        return reached[len - 1] == 1;
    }

    public void canJumpFromPosition(int[] nums, int curIndex, int[] reached) {
        if (reached[curIndex] != -1) {
            return;
        }

        int len = nums.length;
        int maxReach = Math.min(curIndex + nums[curIndex], len - 1);
        for (int i = curIndex + 1; i <= maxReach; i++) {
            reached[i] = 1;
        }
    }


    public static void main(String[] args) {
        // int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        Solution solution = new Solution();
        boolean res = solution.canJump(nums);
        System.out.println(res);
    }
}
