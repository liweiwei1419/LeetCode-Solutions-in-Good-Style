import java.util.Arrays;

public class Solution7 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int maxPrice = 1_000_000_000;

        int[][] dp = new int[n][K + 1];
        // 初始化 1：由于找最短路径，因此初始化的时候赋值成为一个不可能的较大的值
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], maxPrice);
        }
        // 自己到自己，不管经过几个顶点，最短路径都是 0
        for (int i = 0; i <= K; i++) {
            dp[src][i] = 0;
        }

        // 第 1 轮松弛操作，只需要对从 src 出发的边进行松弛操作
        for (int[] flight : flights) {
            if (flight[0] == src) {
                dp[flight[1]][0] = flight[2];
            }
        }

        // 第 2 轮到第 K + 1 轮松弛操作，最后一轮松弛操作是为了检测是否可达
        for (int i = 1; i <= K; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                // 每一次松弛操作的结果是互相独立的，因此只有在上一轮（第 i - 1 轮）得到单源最短路径的顶点，才需要执行松弛操作
                if (dp[from][i - 1] != maxPrice) {
                    dp[to][i] = Math.min(dp[from][i - 1] + flight[2], dp[to][i]);
                }
            }
        }

        // 如果不可达，返回 -1
        if (dp[dst][K] == maxPrice) {
            return -1;
        }
        return dp[dst][K];
    }
}