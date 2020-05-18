public class Solution2 {

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }

        double res = 1;
        while (N > 0) {
            if ((N % 2) == 1) {
                res *= x;
            }

            x *= x;
            N /= 2;
        }
        return res;
    }
}
