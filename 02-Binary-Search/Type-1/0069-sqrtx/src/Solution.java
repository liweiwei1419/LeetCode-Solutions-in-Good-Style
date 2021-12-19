public class Solution {

    // 暴力解法

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        for (int i = 1; i <= x; ++i) {
            if (i == x / i) {
                return i;
            } else if (i > x / i) {
                return i - 1;
            }
        }
        throw new IllegalArgumentException("参数出错");
    }
}