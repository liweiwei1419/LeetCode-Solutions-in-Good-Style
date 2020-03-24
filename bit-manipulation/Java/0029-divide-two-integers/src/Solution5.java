/**
 * @author liweiwei1419
 * @date 2019/10/15 9:16 下午
 */
public class Solution5 {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }
        boolean negative = (dividend > 0) ^ (divisor > 0);
        long dividendLong = abs(dividend);
        long divisorLong = abs(divisor);

        int maxBit = 0;
        long curProduct = divisorLong;
        while (curProduct <= dividendLong) {
            maxBit += 1;
            curProduct <<= 1;
        }

        // System.out.println(maxBit);
        // System.out.println(curProduct);

        long residue = dividendLong;
        int res = 0;
        while (maxBit > 0) {
            maxBit--;
            if (residue - (divisorLong << maxBit) >= 0) {
                res += (1 << maxBit);
                residue -= (divisorLong << maxBit);
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
        int dividend = 28;
        int divisor = 3;
        Solution5 solution5 = new Solution5();
        int res = solution5.divide(dividend, divisor);
        System.out.println(res);
    }
}
