public class Solution2 {

    public double myPow(double x, int n) {
        long b = n;
        return myPow(x, b);
    }

    private double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        if ((n % 2) == 1) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);
    }
}