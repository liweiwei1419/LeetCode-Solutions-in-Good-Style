/**
 * 方法三：并查集
 *
 * @author liweiwei1419
 * @date 2019/9/17 5:10 下午
 */
public class Solution3 {

    class UnionFind {
        private int[] parent;
        private int count;

        // 以索引为 i 的元素为根结点的树的深度（最深的那个深度）
        private int[] rank;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                // 初始化时，所有的元素只包含它自己，只有一个元素，所以 rank[i] = 1
                rank[i] = 1;
            }
        }

        /**
         * 返回索引为 p 的元素的根结点
         *
         * @param p
         * @return
         */
        public int find(int p) {
            // 在 find 的时候执行路径压缩
            while (p != parent[p]) {
                // 编写这句代码的时候可能会觉得有点绕，
                // 技巧是画一个示意图，就能很直观地写出正确的逻辑
                // 两步一跳完成路径压缩
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean connected(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            return pRoot == qRoot;
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

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        int size = rows * cols;
        int[][] directions = {{1, 0}, {0, 1}};
        UnionFind unionFind = new UnionFind(size + 1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        if (newX < rows && newY < cols && grid[newX][newY] == '1') {
                            unionFind.union(cols * i + j, cols * newX + newY);
                        }
                    }
                } else {
                    unionFind.union(cols * i + j, size);
                }
            }
        }
        return unionFind.count - 1;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int res = solution3.numIslands(grid1);
        System.out.println(res);
    }
}
