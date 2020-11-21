import java.util.Arrays;


public class Solution {

    // 方法一：记忆化递归

    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        // 递归终止条件
        if (n == 0) {
            return 0;
        }
        // 如果已经求解过，就直接使用已经求解过的答案
        if (memo[n] != -1) {
            return memo[n];
        }

        // 因为要找最小值，所以初始值赋值成为一个不可能的大值
        int res = Integer.MAX_VALUE;
        for (int i = 1; n - i * i >= 0; i++) {
            res = Math.min(res, 1 + dfs(n - i * i, memo));
        }
        // 求解完成以后应该记录缓存，然后再返回
        return memo[n] = res;
    }
}