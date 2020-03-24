public class Solution4 {

    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        long res = 0;
        // 这一步相当于取绝对值
        x = sign * x;
        // 下面这一步其实是求每个个位数的套路
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        res = sign * res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 1534236469;
        int reverse = solution.reverse(x);
        System.out.println(reverse);
    }
}
