public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int len = coins.length;
        if (len == 0) {
            return -1;
        }

        // dp[i]：组成价值 i 需要的最少硬币数
        int[] dp = new int[amount + 1];

        // 要把 0 算进去，这是基本情况，所以开辟 coins 这么多空间的
        // 初始化的值，可能不符合意义，但是可以被参考
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // 初始化的时候初始化成一个不可能的值
            int minCount = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    minCount = Math.min(dp[i - coin] + 1, minCount);
                }
            }
            dp[i] = minCount == (amount + 1) ? -1 : minCount;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1};
        int amount = 0;
        int coinChange = solution.coinChange(coins, amount);
        System.out.println(coinChange);
    }
}
