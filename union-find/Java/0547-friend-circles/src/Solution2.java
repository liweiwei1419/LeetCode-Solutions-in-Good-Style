import java.util.Arrays;

public class Solution2 {

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
     * 并查集 quick-find 版本
     */
    private class UnionFind {
        private int[] id;
        private int count;
        private int N;

        public UnionFind(int N) {
            this.N = N;
            this.count = N;
            this.id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public int find(int x) {
            return id[x];
        }

        public void union(int x, int y) {
            int xid = find(x);
            int yid = find(y);
            if (xid == yid) {
                return;
            }

            for (int i = 0; i < N; i++) {
                if (id[i] == xid) {
                    id[i] = yid;
                }
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
        Solution2 solution2 = new Solution2();
        int res = solution2.findCircleNum(M);
        System.out.println(res);
    }
}
