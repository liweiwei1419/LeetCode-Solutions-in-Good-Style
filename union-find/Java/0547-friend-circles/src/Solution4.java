import java.util.Arrays;

public class Solution4 {

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
     * 并查集 quick-union（按 size 合并）
     */
    private class UnionFind {
        private int[] parent;
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

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        Solution4 solution3 = new Solution4();
        int res = solution3.findCircleNum(M);
        System.out.println(res);
    }
}
