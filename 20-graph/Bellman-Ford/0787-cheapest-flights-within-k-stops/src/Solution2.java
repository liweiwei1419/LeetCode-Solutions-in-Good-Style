import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    // Dijkstra

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 第 1 步：构建邻接矩阵
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        int res = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        // 队列中保存 [src, 到 src 的花费]
        queue.offer(new int[]{src, 0});
        int k = 0;
        // 第 2 步：开始广度优先遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] head = queue.poll();
                int currentPrice = head[1];

                for (int j = 0; j < n; j++) {
                    // 注意：这里 graph[head[0]][j] > 0
                    if (graph[head[0]][j] > 0) {
                        if (j == dst) {
                            res = Math.min(res, currentPrice + graph[head[0]][dst]);
                            // 注意：这里不能直接返回，因为有松弛操作
                        }
                        if (currentPrice + graph[head[0]][j] < res) {
                            queue.offer(new int[]{j, currentPrice + graph[head[0]][j]});
                        }
                    }
                }
            }

            if (k == K){
                break;
            }
            k++;
        }

        if (res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
}
