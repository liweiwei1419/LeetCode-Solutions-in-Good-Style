public class Solution {

    // 分治思想，写成循环的样子

    public double myPow(double x, int n) {
        // 注意：这里的类型转换
        // 应对 -2147483648 这种用例
        long b = n;
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }

        double res = 1.0;

        while (b > 0) {
            if ((b % 2) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}