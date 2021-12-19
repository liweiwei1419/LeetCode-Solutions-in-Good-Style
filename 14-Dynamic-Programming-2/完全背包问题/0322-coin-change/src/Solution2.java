import java.util.Arrays;

public class Solution2 {

    // 记忆化递归

    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        // 由于 -1 表示当前面值不能凑出，这里初始化为 -2 表示还未计算出来
        Arrays.fill(memo, -2);
        // 排序是为了剪枝方便：一个数减去一个较小的数都小于等于 0 ，减去一个更大的数一定小于 0
        Arrays.sort(coins);
        return dfs(coins, amount);
    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    private int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }

        int res = amount + 1;
        for (int coin : coins) {
            if (amount - coin < 0) {
                break;
            }
            int subRes = dfs(coins, amount - coin);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        if (res == amount + 1) {
            memo[amount] = -1;
            return -1;
        }
        memo[amount] = res;
        return res;
    }
}