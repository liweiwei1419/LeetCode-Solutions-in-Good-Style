public class Solution2 {

    // 二分查找

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 平方以后大于 x 的一定不是解
            // 注意：写成除法，防止 mid * mid 溢出
            if (mid > x / mid) {
                // 下一轮搜索的区间是 [left, mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索的区间是 [mid, right]
                left = mid;
            }
        }
        return left;
    }
}