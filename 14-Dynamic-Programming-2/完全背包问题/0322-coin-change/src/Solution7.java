import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public class Solution7 {

    // 「力扣」第 322 题：零钱兑换，参考代码

    public static final Random random = new Random();

    /**
     * 参数：执行测试的次数
     */
    public static final int TIMES = 1000;

    public int changeForDP(int[] coins, int amount) {
        // 优化空间的动态规划代码
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    /**
     * 注意：该算法仅在 coins = [1, 2, 5, 10, 20, 100] 等具有贪心选择性质的面值列表下有效
     *
     * @param coins
     * @param amount
     * @return
     */
    public int changeForGreedy(int[] coins, int amount) {
        // 将 coins 倒序排列
        coins = IntStream.of(coins).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int res = 0;
        int index = 0;
        // 贪心的点：尽可能多地优先选择面值大的纸币
        while (amount > 0) {
            // 这一步算出当前面值的纸币需要使用多少张
            int count = amount / coins[index];
            // 纸币数加入总数
            res += count;
            // 扣除了当前使用掉的纸币以后还剩下多少金额
            amount %= coins[index];
            // 考虑下一种面额的纸币
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[] coins = new int[]{1, 2, 5, 10, 20, 100};

        for (int i = 0; i < TIMES; i++) {
            int amount = random.nextInt(5000);
            int resOfDp = solution7.changeForDP(coins, amount);
            // System.out.println("动态规划 => " + resOfDp);
            int resOfGreedy = solution7.changeForGreedy(coins, amount);
            // System.out.println("贪心算法 => " + resOfGreedy);
            if (resOfDp != resOfGreedy) {
                throw new RuntimeException("测试不通过！");
            }
        }
        System.out.println("测试通过！");
    }
}