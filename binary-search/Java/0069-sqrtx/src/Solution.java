public class Solution {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid * mid > x) {
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