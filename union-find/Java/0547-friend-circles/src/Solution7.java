public class Solution7 {

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

    /**
     * 并查集 quick-union（路径压缩 2）
     */
    private class UnionFind {
        private int[] parent;

        private int count;
        private int N;

        public UnionFind(int N) {
            this.N = N;
            this.count = N;
            this.parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            // 完全压缩
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
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
        Solution7 solution3 = new Solution7();
        int res = solution3.findCircleNum(M);
        System.out.println(res);
    }
}
