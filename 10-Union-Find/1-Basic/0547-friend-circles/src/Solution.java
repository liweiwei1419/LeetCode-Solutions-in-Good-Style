public class Solution {

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
         * 每个结点的 id 标识，id 标识一样表示被分在一个组
         */
        private int[] id;
        /**
         * 连通分量的个数
         */
        private int count;

        private int N;

        public int getCount() {
            return count;
        }

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

            // 合并之前先做判断
            if (xid == yid) {
                return;
            }
            // 这里需要遍历，时间复杂度为 $O(N)$
            for (int i = 0; i < N; i++) {
                if (id[i] == xid) {
                    id[i] = yid;
                }
            }
            count--;
        }
    }
}