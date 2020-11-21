import java.util.Arrays;


public class Solution {

    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        // - 1 表示还没计算出来
        Arrays.fill(memo, -1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        // 由于要找两个正整的和的最大值，初值化为 0 即可
        int res = 0;
        for (int i = 1; i <= n - 1; i++) {
            // 至少拆分成两个正整数的和，i 是其中一个加法因子，另一个加法因子 n - i 可拆分，也可不拆分
            res = Math.max(res, Math.max(i * (n - i), i * dfs(n - i)));
        }
        memo[n] = res;
        return res;
    }
}