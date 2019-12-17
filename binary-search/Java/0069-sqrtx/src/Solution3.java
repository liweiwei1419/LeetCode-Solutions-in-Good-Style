public class Solution3 {

    // 时间复杂度：O(log N)，这里 N = x
    // 空间复杂度：O(1)

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            // 用除法避免类型转换
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}