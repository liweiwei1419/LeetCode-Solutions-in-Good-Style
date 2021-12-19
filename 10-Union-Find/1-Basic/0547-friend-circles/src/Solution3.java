import java.util.Arrays;

public class Solution3 {

    public int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind unionFind = new UnionFind(len);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }

    private class UnionFind {

        /**
         * 当前结点的父亲结点
         */
        private int[] parent;
        /**
         * 以当前结点为根结点的子树的个数
         */
        private int[] size;

        private int count;
        private int N;

        public UnionFind(int N) {
            this.N = N;
            this.count = N;
            this.parent = new int[N];
            this.size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            Arrays.fill(size, 1);
        }

        public int find(int x) {
            while (x != parent[x]) {
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

            if (size[rootX] == size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += 1;
            } else if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的子树多了 size[rootX] 这么多结点
                // 需要维护定义
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                // 此时以 rootY 为根结点的子树多了 size[rootX] 这么多结点
                // 需要维护定义
                size[rootX] += size[rootY];
            }


            count--;
        }

        public int getCount() {
            return count;
        }
    }
}