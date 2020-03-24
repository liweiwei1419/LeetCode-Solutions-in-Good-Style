/**
 * @author liweiwei1419
 * @date 2019/10/15 3:16 下午
 */
public class Solution2 {

    /**
     * 二分查找
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
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

        if (dividendLong < divisorLong) {
            return 0;
        }

        long left = 1;
        long right = dividendLong;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            if (mid * divisorLong > dividendLong) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (negative) {
            return (int) (-1 * left);
        }
        return (int) left;
    }


    private long abs(int num) {
        if (num >= 0) {
            return num;
        }
        return -1L * num;
    }

    public static void main(String[] args) {
        int dividend = 1;
        int divisor = 2;
        Solution2 solution2 = new Solution2();
        int res = solution2.divide(dividend, divisor);
        System.out.println(res);
    }
}
