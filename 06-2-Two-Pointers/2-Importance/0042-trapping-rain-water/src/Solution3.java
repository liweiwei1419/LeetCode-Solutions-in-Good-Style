public class Solution3 {

    // 方法三：双指针（指针对撞）

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        // 注意初值的选取，前面做了特判，下标 0 和 len - 1 位置都不存雨水，因此这里有效
        // 在区间 [1, len - 2] 里计算存水量
        int left = 1;
        int right = len - 2;

        // 记录区间 [0, left - 1] 的最大高度
        int curLeftHighest = height[0];
        // 记录区间 [right + 1, len - 1] 的最大高度
        int curRightHighest = height[len - 1];

        int res = 0;
        // 这里是等于，因为当 left == right 的时候，left(right) 这个位置的存水量还需要计算一下
        while (left <= right) {
            // 调试代码
            // System.out.println("left = " + left + " right = " + right + " curLeftHighest = " + curLeftHighest + " curRightHighest = " + curRightHighest+ " res = " + res );
            int minHeight = Math.min(curLeftHighest, curRightHighest);

            // 存水单位体积取决于较短的那个柱形的高度
            if (minHeight == curLeftHighest) {
                if (minHeight > height[left]) {
                    // 大于当前，才可以存水
                    res += minHeight - height[left];
                }
                // 更新左边的柱形的最高高度
                curLeftHighest = Math.max(curLeftHighest, height[left]);
                // 指针右移
                left++;
            } else {
                if (minHeight > height[right]) {
                    res += minHeight - height[right];
                }
                curRightHighest = Math.max(curRightHighest, height[right]);
                right--;
            }
        }
        return res;
    }
}