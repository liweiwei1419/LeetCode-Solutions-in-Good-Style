public class Solution11 {

    public boolean canJump(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return true;
        }


        // 贪心算法：贪最远的下标
        int maxReached = 0;

        for (int i = 0; i < len; i++) {
            if (maxReached >= len - 1) {
                return true;
            }

            if (i <= maxReached) {
                maxReached = Math.max(maxReached, i + nums[i]);
            } else {
                return false;
            }

        }
        return true;
    }
}
