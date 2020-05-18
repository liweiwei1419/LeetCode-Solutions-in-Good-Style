public class Solution9 {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return true;
        }

        // 时间复杂度：O(N^2)

        // 从后往前写
        boolean[] can = new boolean[len];
        can[len - 1] = true;
        for (int i = len - 2; i >= 0; i--) {
            can[i] = false;
            for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
                if (can[j]) {
                    // 这里有连环跳，要仔细说清楚
                    can[i] = true;
                    break;
                }
            }
        }
        // 第 1 个位置能够得到即可
        return can[0];
    }
}
