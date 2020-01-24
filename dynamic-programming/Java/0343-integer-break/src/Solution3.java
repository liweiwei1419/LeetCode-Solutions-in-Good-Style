// 找规律的解法
public class Solution3 {

    public int integerBreak(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int maxBreak = s.integerBreak(4);
        System.out.println(maxBreak);
    }
}
