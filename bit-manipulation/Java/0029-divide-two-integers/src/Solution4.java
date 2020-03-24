/**
 * @author liweiwei1419
 * @date 2019/10/15 6:02 下午
 */
public class Solution4 {

    public int divide(int dividend, int divisor) {
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
        int cnt = 0;
        while (dividendLong >= divisorLong) {
            divisorLong <<= 1;
            cnt++;
        }
        // 最高位的上一位，最多是 32
        // System.out.println("cnt:" + "" + cnt);
        int res = 0;
        while (cnt > 0) {
            cnt--;
            divisorLong >>= 1;
            if (dividendLong >= divisorLong) {
                res += (1 << cnt);
                dividendLong -= divisorLong;
            }
        }

        if (negative) {
            return -res;
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
        int dividend = 7;
        int divisor = -3;
        Solution4 solution4 = new Solution4();
        int res = solution4.divide(dividend, divisor);
        System.out.println(res);
    }
}
