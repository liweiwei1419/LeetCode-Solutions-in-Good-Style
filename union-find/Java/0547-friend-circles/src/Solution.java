class UnionFind {
    /**
     * 连通分量的个数
     */
    private int count;
    private int[] parent;
    /**
     * 以索引为 i 的元素为根结点的树的深度（最深的那个深度）
     */
    private int[] rank;

    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            // 初始化时，所有的元素只包含它自己，只有一个元素，所以 rank[i] = 1
            this.rank[i] = 1;
        }
    }

    public int getCount() {
        return this.count;
    }

    public int find(int p) {
        // 在 find 的时候执行路径压缩
        while (p != this.parent[p]) {
            // 两步一跳完成路径压缩
            this.parent[p] = this.parent[this.parent[p]];
            p = this.parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        // 这一步是与第 3 版不同的地方
        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
        // 每次 union 以后，连通分量减 1
        count--;
    }
}

public class Solution {

    public int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        Solution solution = new Solution();
        int res = solution.findCircleNum(M);
        System.out.println(res);
    }
}
