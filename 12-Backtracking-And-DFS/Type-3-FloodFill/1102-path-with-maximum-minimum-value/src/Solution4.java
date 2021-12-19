import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution4 {

    private int rows;
    private int cols;
    public static final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maximumMinimumPath(int[][] A) {
        this.rows = A.length;
        this.cols = A[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // [坐标，数值]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> -o1[1] + o2[1]);
        maxHeap.offer(new int[]{0, A[0][0]});
        visited[0][0] = true;

        int res = Math.min(A[0][0], A[rows - 1][cols - 1]);
        while (!maxHeap.isEmpty()) {
            int[] front = maxHeap.poll();
            int currentX = front[0] / cols;
            int currentY = front[0] % cols;

            res = Math.min(res, front[1]);
            if (currentX == rows - 1 && currentY == cols - 1) {
                return res;
            }

            for (int[] direction : DIRECTIONS) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    maxHeap.offer(new int[]{newX * cols + newY, A[newX][newY]});
                    visited[newX][newY] = true;
                }
            }
        }
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