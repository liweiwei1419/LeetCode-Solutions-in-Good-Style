public class Solution {

    // 暴力解法

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;

            // 找左边第 1 个严格小于 heights[i] 的索引
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            // 找右边第 1 个严格小于 heights[i] 的索引
            while (right < len - 1 && heights[right + 1] >= heights[i]) {
                right++;
            }

            // System.out.println("左：" + left + "，右："+ right + "，高："+ heights[i]);
            int width = right - left + 1;
            res = Math.max(res, width * heights[i]);
        }
        return res;
    }
}