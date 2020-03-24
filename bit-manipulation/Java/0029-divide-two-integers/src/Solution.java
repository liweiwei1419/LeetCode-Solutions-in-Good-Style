public class Solution {

    // 题解区：用负数计算
    // 参考资料：https://blog.csdn.net/Windows_Defender/article/details/80445969
    // https://segmentfault.com/a/1190000013800090

    // 有点像整数的方幂

    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @return
     */
    public int divide(int dividend, int divisor) {
        // 特判
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        boolean negative = (dividend > 0) ^ (divisor > 0);

        long dividendLong = abs(dividend);
        long divisorLong = abs(divisor);

        // 最大方幂数
        int cnt = 0;
        // 把除数不断扩大，直到大于被除数
        while (dividendLong >= divisorLong) {
            cnt += 1;
            divisorLong <<= 1;
        }

        int res = 0;
        while (cnt > 0) {
            cnt -= 1;
            divisorLong >>= 1;
            if (divisorLong <= dividendLong) {
                res += (1 << cnt);
                dividendLong -= divisorLong;
            }
        }
        if (negative) {
            res = -res;
        }
        return res;
    }

    private long abs(int num) {
        if (num >= 0) {
            return num;
        }
        return -1L * num;
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 2;
        Solution solution = new Solution();
        int res = solution.divide(dividend, divisor);
        System.out.println(res);
    }
}
