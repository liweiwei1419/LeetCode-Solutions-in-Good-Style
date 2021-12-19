import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3 {

    // 标准 Dijkstra 的写法

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // 使用邻接矩阵表示有向图，0 表示不连通
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 向集合添加一个记录 [起点, 费用, 站数限制] 的数组，K + 1 表示可以走过站点的个数2
        minHeap.offer(new int[]{src, 0, K + 1});

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            // 起始顶点
            int v = front[0];
            // 从 src 到 s 的累计花费
            int price = front[1];
            // 剩余还可以中转多少次
            int k = front[2];


            // 起点等于终点
            if (v == dst) {
                return price;
            }

            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    if (graph[v][i] > 0) {
                        minHeap.offer(new int[]{i, price + graph[v][i], k - 1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int n = 4;
        int[][] flights = new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};

        int src = 0;
        int dst = 3;
        int K = 1;

        int res = solution3.findCheapestPrice(n, flights, src, dst, K);
        System.out.println(res);
    }
}