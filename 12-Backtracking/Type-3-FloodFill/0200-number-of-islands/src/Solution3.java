public class Solution3 {

    // 方法三：并查集（方法一和方法二在第 12 章）

    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;

        // 空地的数量
        int spaces = 0;
        UnionFind unionFind = new UnionFind(rows * cols);
        int[][] directions = {{1, 0}, {0, 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    spaces++;
                } else {
                    // 此时 grid[i][j] == '1'
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        // 先判断坐标合法，再检查右边一格和下边一格是否是陆地
                        if (newX < rows && newY < cols && grid[newX][newY] == '1') {
                            unionFind.union(getIndex(i, j), getIndex(newX, newY));
                        }
                    }
                }
            }
        }
        return unionFind.getCount() - spaces;
    }

    private int getIndex(int i, int j) {
        return i * cols + j;
    }

    private class UnionFind {
        /**
         * 连通分量的个数
         */
        private int count;
        private int[] parent;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return;
            }

            parent[xRoot] = yRoot;
            count--;
        }
    }
}