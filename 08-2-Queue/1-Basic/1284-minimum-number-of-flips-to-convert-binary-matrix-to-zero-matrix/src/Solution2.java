import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2 {

    private void flip(int[][] mat, int x, int y) {
        for (int i = 0; i < 5; i++) {
            int newX = x + DIRECTIONS[i][0];
            int newY = y + DIRECTIONS[i][1];

            if (inArea(newX, newY)) {
                // 翻转要使用异或运算
                mat[newX][newY] ^= 1;
            }
        }
    }


    private int toBoard(int[][] mat) {
        int board = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    board |= (1 << getIndex(i, j));
                }
            }
        }
        return board;
    }

    private void toMatrix(int board, int[][] mat) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((board & (1 << getIndex(i, j))) != 0) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = 0;
                }
            }
        }
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
        int start = toBoard(mat);
        if (start == 0) {
            return 0;
        }

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(start);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            toMatrix(top[0], mat);
            int step = top[1] + 1;

            // 这里暴力搜索
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    flip(mat, i, j);

                    int newBoard = toBoard(mat);
                    if (newBoard == 0) {
                        return step;
                    }

                    if (!hashSet.contains(newBoard)) {
                        hashSet.add(newBoard);
                        queue.offer(new int[]{newBoard, step});
                    }

                    // 记得，这里要翻转回去
                    flip(mat, i, j);
                }
            }
        }
        return -1;
    }
}