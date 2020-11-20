public class Solution {
    
    private boolean[] visited;
    private int[] colors;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;

        // 图中顶点的个数
        int V = graph.length;

        // 一个顶点是否被访问过，使用 visited 控制
        visited = new boolean[V];
        colors = new int[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (!dfs(i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 从顶点 i 开始染色
     *
     * @param i
     * @param color 对顶点 i 尝试染色 color
     * @return 是否染色成功
     */
    private boolean dfs(int i, int color) {
        visited[i] = true;
        colors[i] = color;
        int[] successors = graph[i];
        for (int successor : successors) {
            if (!visited[successor]) {
                // 还没见过，尝试染色
                if (!dfs(successor, 1 - color)) {
                    return false;
                }
            } else if (colors[i] == colors[successor]) {
                // 如果已经见过了，两边的颜色需要不一致
                return false;
            }
        }
        return true;
    }
}