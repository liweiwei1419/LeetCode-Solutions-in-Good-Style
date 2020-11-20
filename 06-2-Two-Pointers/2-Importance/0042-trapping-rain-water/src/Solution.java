public class Solution {

    // 暴力解法：找到两边最高的那个高度，还要减去自己的高度

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        int res = 0;
        // 对区间 [1, len - 2] 的每个位置，分别计算可以存水的单位体积
        for (int i = 1; i < len - 1; i++) {
            int leftHighest = max(height, 0, i - 1);
            int rightHighest = max(height, i + 1, len - 1);

            // 木桶原理，存水的高度取决于二者之中的较矮者
            int curHeight = Math.min(leftHighest, rightHighest);
            if (curHeight > height[i]) {
                res += (curHeight - height[i]);
            }
        }
        return res;
    }

    private int max(int[] height, int left, int right) {
        int res = height[left];
        for (int i = left + 1; i <= right; i++) {
            res = Math.max(res, height[i]);
        }
        return res;
    }
}