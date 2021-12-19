public class Solution {

    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }


        int[][] dp = new int[len + 1][sum / 2 + 1];
        for (int i = 1; i <= len; ++i) {
            int currStone = stones[i - 1];
            for (int j = 1; j <= sum / 2; ++j) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if (j >= currStone) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - currStone] + currStone);
                }
            }
        }
        return sum - 2 * dp[len][sum / 2];
    }
}