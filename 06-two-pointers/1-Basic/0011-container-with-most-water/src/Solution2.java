public class Solution2 {

    // 指针对撞

    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            // 0 或者 1 的时候，不能形成区间，所以不能形成容器
            return 0;
        }

        int left = 0;
        int right = len - 1;
        int res = 0;
        while (left < right) {
            // 木桶原理，取决于最短的那根木板
            // [1, 2, 3] 3 和 1 之间的长度就是 (3 - 1 = )2
            int area = (right - left) * Math.min(height[left], height[right]);

            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                // height[l] >= height[r]
                right--;
            }
        }
        return res;
    }
}