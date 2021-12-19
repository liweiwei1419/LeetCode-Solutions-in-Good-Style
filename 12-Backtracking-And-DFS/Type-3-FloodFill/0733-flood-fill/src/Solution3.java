public class Solution3 {

    // 方法三：并查集

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if (originColor == newColor) {
            return image;
        }

        // 注意：这里只有两个方向向量
        int[][] directions = new int[][]{{1, 0}, {0, 1}};
        int rows = image.length;
        int cols = image[0].length;

        // 步骤 1：把与当前单元格在两个方向相邻、且颜色等于 (sr, sc) 单元格颜色的单元格进行合并
        UnionFind unionFind = new UnionFind(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果不是要染色的单元格，跳过
                if (image[i][j] != originColor) {
                    continue;
                }

                for (int[] direction : directions) {
                    int newX = i + direction[0];
                    int newY = j + direction[1];
                    if (inArea(newX, newY, rows, cols) && image[newX][newY] == originColor) {
                        unionFind.union(getIndex(newX, newY, cols), getIndex(i, j, cols));
                    }
                }
            }
        }

        // 步骤 2：把与 (sr, sc) 在同一个集合中的元素进行染色
        // 源点坐标转换成一维坐标
        int sourceIndex = getIndex(sr, sc, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (unionFind.isConnected(getIndex(i, j, cols), sourceIndex)) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    private class UnionFind {
        private int[] parent;
        private int N;

        public UnionFind(int N) {
            this.N = N;
            this.parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                // 路径压缩：隔代压缩
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
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}