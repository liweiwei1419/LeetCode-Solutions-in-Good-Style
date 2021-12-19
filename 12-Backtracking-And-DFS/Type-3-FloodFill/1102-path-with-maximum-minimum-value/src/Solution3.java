import java.util.Arrays;

public class Solution3 {

    private int rows;
    private int cols;
    public static final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maximumMinimumPath(int[][] A) {
        this.rows = A.length;
        this.cols = A[0].length;

        int size = rows * cols;

        // 数组 B 的第一维是并查集里的坐标，第二维是在 A 中的数组，即 [(坐标, 数值), (坐标, 数值), ...] 这种形式
        int[][] B = new int[size][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                B[i * cols + j] = new int[]{i * cols + j, A[i][j]};
            }
        }


        // 按照数值降序排列
        Arrays.sort(B, (o1, o2) -> -o1[1] + o2[1]);

        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            int currentIndex = B[i][0];
            int currentValue = B[i][1];

            int currentX = currentIndex / cols;
            int currentY = currentIndex % cols;


            for (int[] direction : DIRECTIONS) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];

                if (inArea(newX, newY) && A[newX][newY] >= currentValue) {
                    unionFind.union(currentIndex, newX * cols + newY);
                }
            }


            if (unionFind.isConnected(0, size - 1)) {
                return currentValue;
            }
        }
        // 代码不会走到这里
        return -1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    /**
     * 最基本的并查集实现（只加了路径压缩，不维护连通分量的个数）
     */
    private class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
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