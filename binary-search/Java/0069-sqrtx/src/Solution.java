public class Solution {

    // 时间复杂度：O(log N)，这里 N = x
    // 空间复杂度：O(1)

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}