import java.util.Arrays;

public class Solution3 {

    // 记忆化递归
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        Arrays.sort(coins);
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        int res = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != -2) {
            return memo[amount];
        }

        for (int coin : coins) {
            if (amount - coin < 0) {
                break;
            }

            int subRes = dfs(coins, amount - coin, memo);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        return memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] coins = {2};
        int amount = 3;
        int res = solution3.coinChange(coins, amount);
        System.out.println(res);
    }
}
