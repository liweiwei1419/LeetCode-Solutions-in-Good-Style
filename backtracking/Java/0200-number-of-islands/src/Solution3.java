/**
 * 方法三：并查集
 *
 * @author liweiwei1419
 * @date 2019/9/17 5:10 下午
 */
public class Solution3 {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;

        int size = rows * cols;
        // 两个方向的方向向量（理解为向下和向右的坐标偏移）
        int[][] directions = {{1, 0}, {0, 1}};
        // +1 是认为虚拟的水域
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
                    // 如果不是陆地，所有的水域和一个虚拟的水域连接
                    unionFind.union(cols * i + j, size);
                }
            }
        }

        // 减去那个一开始多设置的虚拟的水域
        return unionFind.count - 1;
    }


    class UnionFind {

        private int[] parent;
        private int count;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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
                // 两步一跳完成路径压缩，这里是「隔代压缩」
                // 说明：「隔代压缩」和「按秩合并」选择一个实现即可，「隔代压缩」的代码量少，所以选它
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
            parent[qRoot] = pRoot;
            // 每次 union 以后，连通分量减 1
            count--;
        }
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
