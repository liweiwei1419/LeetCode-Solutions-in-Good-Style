public class Solution4 {

    // 数学方法

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        // 根据组合数公式，选 m - 1 和 n - 1 结果是一样的，
        // 我们选二者之中的较小者是为了使得连乘计算的数更少
        int min = Math.min(m - 1, n - 1);
        long res = continuedProduct(m + n - min - 1, m + n - 2);
        res /= continuedProduct(1, min);
        return (int) res;
    }

    /**
     * @param begin
     * @param end
     * @return 计算连乘 begin * (begin + 1) * .. * end，
     * 结果值可能会很大，因此使用 32 位长整形保存答案
     */
    private long continuedProduct(int begin, int end) {
        //
        long ret = 1;
        for (int i = begin; i <= end; i++) {
            ret *= i;
        }
        return ret;
    }
}