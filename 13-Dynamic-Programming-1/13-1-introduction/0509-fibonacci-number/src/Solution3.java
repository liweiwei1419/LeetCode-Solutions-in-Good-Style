import java.util.Arrays;

public class Solution3 {

    public int fib(int N) {
        if (N < 2) {
            return N;
        }

        // 0 要占一个位置，所以设置 N + 1 个位置
        int[] memo = new int[N + 1];
        // 还未计算过的值用 -1 表示
        Arrays.fill(memo, -1);
        return fib(N, memo);
    }

    public int fib(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (memo[n] == -1) {
            memo[n] = fib(n - 1) + fib(n - 2);
        }
        return memo[n];
    }
}