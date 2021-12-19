public class Solution {

    public int makeConnected(int n, int[][] connections) {
        // 特判
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFind unionFind = new UnionFind(n);

        // 多余的边的条数
        int cnt = 0;
        for (int[] connection : connections) {
            boolean success = unionFind.union(connection[0], connection[1]);
            if (!success) {
                cnt++;
            }
        }

        // 特判
        if (unionFind.count == 1) {
            return 0;
        }

        // 扣掉的 1 是当前结点数最大的连通分量
        if (cnt < unionFind.count - 1) {
            return -1;
        }
        return unionFind.count - 1;
    }

    private class UnionFind {
        /**
         * 父亲结点标识数组
         */
        private int[] parent;
        /**
         * 连通分量个数
         */
        private int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                // 路径压缩（隔代压缩）
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        /**
         * @param x
         * @param y
         * @return 是否合并成功，如果 x 和 y 本来就在一个连通分量里，返回 false
         */
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            parent[rootX] = rootY;
            count--;
            return true;
        }
    }
}