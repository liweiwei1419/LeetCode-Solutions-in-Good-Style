public class Solution5 {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        // 取最小的，减少计算量
        int min = Math.min(m - 1, n - 1);
        long ret = factor(m + n - 2, m + n - 2 - min + 1);
        ret /= factor(min, 1);
        return (int) ret;
    }

    // 求 k * (k+1) * ... * n 的乘积
    private long factor(int n, int k) {
        long ret = 1;
        for (int i = n; i >= k; i--) {
            ret *= i;
        }
        return ret;
    }
}
