import java.util.Arrays;

public class Solution {

    private class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
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

        /**
         * @param x
         * @param y
         * @return 如果合并成功返回 true
         */
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            return true;
        }
    }


    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;

        // 入度数组，记录指向某个结点的边的条数
        int[] inDegree = new int[len + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        // 从后向前看，如果某个顶点的入度为 2，尝试把它去掉，看看会不会构成环
        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                // 如果不构成环，这条边就是要去掉的那条边
                if (!judgeCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }

        // 从后向前看，如果某个顶点的入度为 1，尝试把它去掉，看看会不会构成环
        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 1) {
                // 如果不构成环，这条边就是要去掉的那条边
                if (!judgeCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }
        throw new IllegalArgumentException("输入不符合要求。");
    }

    /**
     * 将 remove 去掉以后，剩下的有向边是否构成环
     *
     * @param edges
     * @param len
     * @param remove
     * @return 构成环，返回 true
     */
    private boolean judgeCircle(int[][] edges, int len, int remove) {
        UnionFind unionFind = new UnionFind(len + 1);
        for (int i = 0; i < len; i++) {
            if (i == remove) {
                continue;
            }
            if (!unionFind.union(edges[i][0], edges[i][1])) {
                // 合并失败，表示 edges[i][0] 和 edges[i][1] 在一个连通分量里，即构成了环
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 1}, {1, 4}};
        Solution solution = new Solution();
        int[] res = solution.findRedundantDirectedConnection(edges);
        System.out.println(Arrays.toString(res));
    }
}
