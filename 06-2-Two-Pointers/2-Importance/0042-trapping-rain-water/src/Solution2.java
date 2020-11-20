public class Solution2 {

    // 方法二：动态规划

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        // leftHighest[i] 定义：区间 [0, i - 1] 中的最大值
        int[] leftHighest = new int[len];
        // 下标为 0 和 下标为 len - 1 的位置不用计算，下面同理
        for (int i = 1; i < len - 1; i++) {
            leftHighest[i] = Math.max(height[i - 1], leftHighest[i - 1]);
        }

        // rightHighest[i] 定义：区间 [i + 1, len - 1] 中的最大值
        int[] rightHighest = new int[len];
        for (int i = len - 2; i > 0; i--) {
            rightHighest[i] = Math.max(height[i + 1], rightHighest[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int minHeight = Math.min(leftHighest[i], rightHighest[i]);
            if (height[i] < minHeight) {
                res += minHeight - height[i];
            }
        }
        return res;
    }
}