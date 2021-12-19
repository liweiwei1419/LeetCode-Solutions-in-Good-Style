public class Solution {

    // 深度优先遍历（回溯算法）

    private int[][] graph;
    private boolean[] visited;
    private int res = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        K = Math.min(K, n - 2);

        // 建图（有向图）
        this.graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        // 图的广度优先遍历需要 visited 数组
        this.visited = new boolean[n];
        // 开始深度优先遍历，注意：这里传 K + 1，这是因为 K 次经停，总共 K + 1 个站
        dfs(src, dst, K + 1, 0);

        // 特殊判断
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }


    /**
     * 从 src 出发，到 dst 为止，最多经过 k 站（这里 k 包括 src）
     *
     * @param src  起点站
     * @param dst  终点站
     * @param k    经过的站点数限制
     * @param cost 已经花费的价格
     */
    private void dfs(int src, int dst, int k, int cost) {
        if (src == dst) {
            res = cost;
            return;
        }

        if (k == 0) {
            return;
        }

        // 遍历 src 的邻接顶点
        for (int i = 0; i < graph[src].length; i++) {
            if (graph[src][i] > 0) {
                // 这里 graph[src][i] 表示存在一条有向边
                if (visited[i]) {
                    continue;
                }

                // 剪枝：跳过可能产生较高费用的路径，从而选出最少价格
                if (cost + graph[src][i] > res) {
                    continue;
                }

                visited[i] = true;
                dfs(i, dst, k - 1, cost + graph[src][i]);
                // 回溯
                visited[i] = false;
            }
        }
    }
}