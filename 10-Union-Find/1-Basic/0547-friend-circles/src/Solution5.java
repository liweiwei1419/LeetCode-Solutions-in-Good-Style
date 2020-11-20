import java.util.Arrays;

public class Solution5 {

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
        private int[] parent;
        private int[] rank;

        private int count;
        private int N;

        public int getCount() {
            return count;
        }

        public UnionFind(int N) {
            this.N = N;
            this.count = N;
            this.parent = new int[N];
            this.rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            Arrays.fill(rank, 1);
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

            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度仅加了 1
                rank[rootY] += 1;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度不变
            } else {
                // 同理，此时以 rootX 为根结点的树的高度不变
                parent[rootY] = rootX;
            }
            count--;
        }
    }
}