public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        // 二维数组中的整数在 1 到 N 之间，其中 N 是输入数组的大小
        // 为了不处理偏移，多开一个空间
        UnionFind unionFind = new UnionFind(len + 1);
        for (int[] edge : edges) {
            boolean success = unionFind.union(edge[0], edge[1]);
            if (!success) {
                return edge;
            }
        }
        return new int[0];
    }

    private class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 实现了路径压缩
         *
         * @param x
         * @return 代表元
         */
        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        /**
         * 注意：将是否合并成功返回给调用者
         *
         * @param x
         * @param y
         * @return 如果 x 和 y 属于同一个集合，返回 true
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
}