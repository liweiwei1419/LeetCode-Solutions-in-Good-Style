public class Solution2 {

    private int rows;
    private int cols;

    // 方法二：并查集

    public boolean containsCycle(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {0, 1}};
        UnionFind unionFind = new UnionFind(cols * rows);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                char current = grid[i][j];
                for (int[] direction : directions) {
                    int newX = i + direction[0];
                    int newY = j + direction[1];
                    if (inArea(newX, newY) && current == grid[newX][newY]) {
                        if (unionFind.union(getIndex(i, j), getIndex(newX, newY))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return 0 <= x && x < rows && 0 <= y && y < cols;
    }

    private int getIndex(int x, int y) {
        return x * cols + y;
    }

    private class UnionFind {

        private int[] parent;

        public UnionFind(int N) {
            parent = new int[N];
            for (int i = 0; i < N; ++i) {
                parent[i] = i;
            }
        }

        private int find(int x) {
            if (parent[x] != x) {
                // 完全压缩
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * @param x
         * @param y
         * @return 如果在同一个集合中，返回 true
         */
        public boolean union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return true;
            }
            if (parentX < parentY) {
                parent[parentY] = parentX;
            } else {
                parent[parentX] = parentY;
            }
            return false;
        }
    }
}
