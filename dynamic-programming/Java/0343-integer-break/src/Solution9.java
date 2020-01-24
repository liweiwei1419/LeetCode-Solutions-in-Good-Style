public class Solution {

    private int[] memo;

    /**
     * 记忆化递归
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        memo = new int[n + 1];
        return find(n);
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int find(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 1) {
            memo[1] = 1;
            return 1;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxVal = max3(maxVal, i * (n - i), i * find(n - i));
        }
        memo[n] = maxVal;
        return memo[n];
    }
}