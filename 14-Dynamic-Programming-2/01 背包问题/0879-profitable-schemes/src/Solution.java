import java.util.Arrays;

public class Solution {

    // 方法一：记忆化递归
    // dp[i][j][k]：表示在前 i 个物品中选择，装入 j 容量的背包中，达到 k 价值的方案数

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        len = group.length;
        this.P = P;
        memo = new int[len + 1][G + 1][P + 1];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= G; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        this.group = group;
        this.profit = profit;
        return dfs(0, G, 0);
    }

    private int[][][] memo;
    private int len;
    private int P;
    private int[] group;
    private int[] profit;
    private int mod = 1000000000 + 7;

    private int dfs(int i, int g, int p) {
        if (i >= len) {
            // 利益到达 P，该方案就能累计（为 1）
            if (p == P) {
                return 1;
            }
            // 否则不能累计
            return 0;
        }

        if (memo[i][g][p] != -1) {
            return memo[i][g][p];
        }

        // 策略1：不做
        int res = dfs(i + 1, g, p);
        // 策略2：做（前提是剩余人数足够）
        if (g >= group[i]) {
            res += dfs(i + 1, g - group[i], Math.min(p + profit[i], P));
        }
        return memo[i][g][p] = res % mod;
    }
}
