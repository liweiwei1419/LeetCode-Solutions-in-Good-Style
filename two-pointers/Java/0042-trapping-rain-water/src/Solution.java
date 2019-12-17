public class Solution {

    // 暴力解法：中心扩散，找到两边最高的那个高度，还要减去自己的高度

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int leftMax = leftMax(height, i);
            int rightMax = rightMax(height, i, len);

            if (height[i] < Math.min(leftMax, rightMax)) {
                res += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return res;
    }

    /**
     * 计算 center 的左边的柱子的最高高度（不包括 center 位置）
     *
     * @param height
     * @param center
     * @return
     */
    private int leftMax(int[] height, int center) {
        int res = 0;
        for (int i = center - 1; i >= 0; i--) {
            res = Math.max(res, height[i]);
        }
        return res;
    }

    /**
     * 计算 center 的右边的柱子的最高高度（不包括 center 位置）
     *
     * @param height
     * @param center
     * @param n
     * @return
     */
    private int rightMax(int[] height, int center, int n) {
        // 看看向右最多能走多远
        int res = 0;
        for (int i = center + 1; i < n; i++) {
            res = Math.max(res, height[i]);
        }
        return res;
    }
}
