import java.util.Arrays;

public class Solution5 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 剪枝
        K = Math.min(K, n - 2);
        int maxPrice = 1000_000_000;


        int[][] dist = new int[n][K + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], maxPrice);
        }


        dist[src][0] = 0;
        // 执行了一次松弛操作
        for (int[] flight : flights) {
            if (flight[0] == src) {
                dist[flight[1]][0] = Math.min(dist[flight[1]][0], flight[2]);
            }
        }

        // 执行 K - 1 次松弛操作
        for (int k = 1; k <= K; k++) {
            for (int[] flight : flights) {
                dist[flight[1]][k] = Math.min(dist[flight[1]][k - 1], Math.min(dist[flight[1]][k], dist[flight[0]][k - 1] + flight[2]));
            }
        }
        if (dist[dst][K] == maxPrice) {
            return -1;
        }
        return dist[dst][K];
    }
}
