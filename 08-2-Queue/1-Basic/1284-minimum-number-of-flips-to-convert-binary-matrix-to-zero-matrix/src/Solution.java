import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int flip(int board, int x, int y) {
        for (int i = 0; i < 5; i++) {
            int newX = x + DIRECTIONS[i][0];
            int newY = y + DIRECTIONS[i][1];

            if (inArea(newX, newY)) {
                // 翻转要使用异或运算
                board ^= (1 << getIndex(newX, newY));
            }
        }
        return board;
    }

    private int getIndex(int x, int y) {
        return x * cols + y;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private final static int[][] DIRECTIONS = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}, {0, 0}};
    private int rows;
    private int cols;

    public int minFlips(int[][] mat) {
        rows = mat.length;
        cols = mat[0].length;
        // 初始化棋盘
        int start = 0;
        // 填写原始棋盘
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    start |= (1 << getIndex(i, j));
                }
            }
        }

        boolean[] visited = new boolean[1 << (rows * cols)];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int top = queue.poll();
                if (top == 0) {
                    return steps;
                }

                // 这里暴力搜索
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        int flipBoard = flip(top, i, j);
                        if (visited[flipBoard]) {
                            continue;
                        }
                        visited[flipBoard] = true;
                        queue.offer(flipBoard);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}