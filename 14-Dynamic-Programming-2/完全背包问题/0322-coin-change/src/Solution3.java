import java.util.Arrays;

public class Solution3 {

    // 参考资料：https://leetcode-cn.com/problems/coin-change/solution/322-by-ikaruga/

    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
            dfs(coins, amount - (i * coins[index]), index - 1, count + i);
        }
    }
}
