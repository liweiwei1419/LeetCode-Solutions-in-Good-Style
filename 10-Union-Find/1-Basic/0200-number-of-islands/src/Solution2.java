public class Solution2 {

    // 这个并查集的做法没有 Solution 好

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0}};

        int size = rows * cols;
        // 多开一个结点，把 '0' 都与最后这个结点连在一起
        UnionFind unionFind = new UnionFind(size + 1);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        if (inArea(newX, newY, rows, cols) && grid[newX][newY] == '1') {
                            unionFind.union(getIndex(i, j, cols), getIndex(newX, newY, cols));
                        }
                    }
                } else {
                    unionFind.union(getIndex(i, j, cols), size);
                }
            }

        }
        return unionFind.getCount() - 1;
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    private class UnionFind {

        private int[] parent;
        /**
         * 连通分量个数
         */
        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                // 只实现了路径压缩，并且是隔代压缩
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
            parent[rootX] = rootY;
            count--;
        }
    }
}
