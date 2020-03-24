/**
 * @author liweiwei1419
 * @date 2019/10/15 5:48 下午
 */
public class Solution3 {

    // 全变成负数，便于计算

    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @return
     */
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int res = 0;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        // 都变成负数，就可以回避对边界的讨论
        // <= 其实就是 |dividend| >= divisor
        while (dividend <= divisor) {
            int tempRes = -1;
            int tempDivisor = divisor;
            while (dividend <= (tempDivisor << 1)) {
                if (tempDivisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                tempRes = tempRes << 1;
                tempDivisor = tempDivisor << 1;
            }
            dividend = dividend - tempDivisor;
            res += tempRes;
        }
        if (!sign) {
            if (res <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            res = -res;
        }
        return res;
    }

}
