import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution3 {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        if (m == 1 && n == 1) {
            return 0;
        }

        // 建图：第一维是坐标，第二维是边（相邻的边的差）
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int index = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{index - n, index, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{index - 1, index, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }

        // 原地排序：从小到大
        edges.sort(Comparator.comparingInt(edge -> edge[2]));

        UnionFind unionFind = new UnionFind(m * n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int v = edge[2];
            unionFind.union(x, y);
            if (unionFind.isConnected(0, m * n - 1)) {
                return v;
            }
        }
        return -1;
    }

    private class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
