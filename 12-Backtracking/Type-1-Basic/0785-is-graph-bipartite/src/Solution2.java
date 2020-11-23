public class Solution2 {

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        // 初始化为 -1 表示还没有上色
        for (int i = 0; i < len; i++) {
            colors[i] = -1;
        }

        for (int i = 0; i < len; i++) {
            if (colors[i] == -1) {
                // 重点理解这句，如果这个点与之前的点不相邻，可以任意赋值
                colors[i] = 0;
                boolean colorRepeat = dfs(graph, colors, i);
                if (colorRepeat) {
                    return false;
                }
            } else {
                boolean colorRepeat = dfs(graph, colors, i);
                if (colorRepeat) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param graph
     * @param colors
     * @param vertex
     * @return 涂色的时候是否遇到重复，color repeat
     */
    private boolean dfs(int[][] graph, int[] colors, int vertex) {
        int currentColor = colors[vertex];
        int[] neighbours = graph[vertex];

        // 如果邻居还未着色，就着不一样的颜色
        // 如果已经着色，就检查是否异色，如果同色，返回重复，如果异色，继续递归

        for (int neighbour : neighbours) {
            if (colors[neighbour] == -1) {
                colors[neighbour] = currentColor ^ 1;
            } else {
                if (colors[neighbour] == currentColor) {
                    return true;
                }
            }
        }
        return false;
    }
}