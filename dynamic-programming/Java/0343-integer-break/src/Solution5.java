public class Solution5 {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        // 接下来就是 n >= 5 的时候的逻辑了
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int integerBreak = solution2.integerBreak(8);
        System.out.println(integerBreak);
    }
}