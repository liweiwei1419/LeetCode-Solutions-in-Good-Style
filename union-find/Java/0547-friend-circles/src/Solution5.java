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
        return unionFind.count;
    }

    /**
     * 并查集 quick-union（按 rank 合并）
     */
    private class UnionFind {
        private int[] parent;
        private int[] rank;

        private int count;
        private int N;

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
                // 此时以 rootY 为根结点的树没有变得更高
            } else {
                parent[rootY] = rootX;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        Solution5 solution3 = new Solution5();
        int res = solution3.findCircleNum(M);
        System.out.println(res);
    }
}
