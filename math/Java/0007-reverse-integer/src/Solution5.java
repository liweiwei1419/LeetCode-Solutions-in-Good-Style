public class Solution5 {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = -1 * x;
        }

        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        res *= sign;
        if (res > Integer.MAX_VALUE || res< Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int reverse = solution2.reverse(123);
        System.out.println(reverse);
    }
}
