public class Solution10 {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return true;
        }

        // 时间复杂度：O(N)

        // 从后往前写
        boolean[] can = new boolean[len];
        can[len - 1] = true;

        // 最左边可以到达的数组下标
        int left = len - 1;

        for (int i = len - 2; i >= 0; i--) {

            // 贪心算法核心步骤
            can[i] = (i + nums[i] >= left);
            if (can[i]) {
                left = i;
            }

        }
        // 第 1 个位置能够得到即可
        return can[0];
    }
}
