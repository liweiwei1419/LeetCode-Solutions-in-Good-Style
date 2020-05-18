public class Solution4 {

    // 参考资料：https://leetcode-cn.com/problems/stone-game/solution/dong-tai-gui-hua-fang-shi-xiang-jie-java-by-yan-ta/

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }

        // 注意这里的两个循环
        // 第一个循环 k 代表间隔距离，比如说 k = 1时，配合接下来 i 的循环，
        // 会不断得到相邻 2 个石头堆的最优选择策略，比如说 [1, 2, 3, 4] 时，
        // 会得到 [1, 2]、[2, 3]、[3, 4] 的最优选择策略
        // 当 k = 2 时，会得到相邻 3 个石头堆的最优选择策略，得到 [1, 2, 3] [2, 3, 4]。


        for (int k = 1; k < len; k++) {
            // i 仍然表示起始位置
            for (int i = 0; i < len - k; i++) {
                // i + k 表示终点位置
                dp[i][i + k] = Math.max(piles[i] - dp[i + 1][i + k], piles[i + k] - dp[i][i + k - 1]);
            }
        }

        // 输出
        return dp[0][len - 1] > 0;
    }

}