public class Solution2 {

    // 动态规划：使用滚动变量
    // 时间复杂度：O(N)
    // 空间复杂度：O(1)

    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i < N + 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    // 其它解法：记忆化递归、矩阵乘法
}