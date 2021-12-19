import java.util.Arrays;

public class Solution4 {

    // 原来的官方题解

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dist = new int[2][n];

        // 这个数可以自行定义，不一定要定成现在这个样子
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dist[0], INF);
        Arrays.fill(dist[1], INF);
        dist[0][src] = 0;
        dist[1][src] = 0;

        for (int i = 0; i <= K; ++i) {
            for (int[] edge : flights) {
                dist[i & 1][edge[1]] = Math.min(dist[i & 1][edge[1]], dist[~i & 1][edge[0]] + edge[2]);
            }
        }

        if (dist[K & 1][dst] < INF) {
            return dist[K & 1][dst];
        }
        return -1;
    }

}
