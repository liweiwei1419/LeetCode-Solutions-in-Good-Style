public class Solution3 {

    // 空间优化的写法

    // dp[j][k] 的含义为当前 i 序号的犯罪，在 j 名罪犯的行动下，获取 k 的利益。

    // 那么 `dp[j][0] = 1`，因为如果不需要获取利益，罪犯人数符合条件都可以满足为方法。
    // 此题需要注意的是空间压缩时，k >= 0 而不是 k >= P，
    // 我们可以看到 `dp[j][k] += dp[j - g][k - max(k - p, 0)]`。

    // 这是因为在剩余所需的利益 `k` 小于当前罪行带来的 `p` 时，坐标可能小于 `0 ，但是这种情况依然是满足条件的，

    // 比如总利益为 `5`，单个罪行利益为6，我们依旧需要把它们算上。


    /**
     * @param n         员工数量（限制条件）
     * @param minProfit 最小利润（目标值）
     * @param group     group[i]：表示当前这种工作需要的员工数
     * @param profit    profit[i]：表示当前这种工作可以产生的利润
     * @return
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int mod = 1000000000 + 7;
        int[][] dp = new int[n + 1][minProfit + 1];


        for (int j = 0; j <= n; ++j) {
            dp[j][0] = 1;
        }
        for (int i = 1; i <= len; ++i) {
            int g = group[i - 1];
            int p = profit[i - 1];
            for (int j = n; j >= g; --j) {
                for (int k = minProfit; k >= 0; --k) {
                    dp[j][k] += dp[j - g][Math.max(k - p, 0)];
                    dp[j][k] %= mod;
                }
            }
        }
        return dp[n][minProfit];
    }
}
