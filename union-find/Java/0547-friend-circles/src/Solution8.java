public class Solution8 {

    private class UnionFind {
        private int[] parent;
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
            count--;
            parent[rootX] = rootY;
        }
    }

    public int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind unionFind = new UnionFind(len);

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};

        Solution8 solution = new Solution8();
        int res = solution.findCircleNum(M);
        System.out.println(res);
    }
}
