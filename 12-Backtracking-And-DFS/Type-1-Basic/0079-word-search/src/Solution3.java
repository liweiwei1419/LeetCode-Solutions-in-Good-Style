public class Solution3 {


    private boolean[][] isVisited;
    private char[][] board;
    private int[][] Directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m, n;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        if (m == 0) {
            return word.length() == 0;
        }

        this.n = board[0].length;
        this.word = word;
        this.board = board;
        this.isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (back(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean back(int x, int y, int start) {
        // 这里逻辑错了，遍历到 word 的最后一个字符的时候，一定需要返回结果
        // 你再对比一下你写的，看看二者有何不同
        if (start == word.length() - 1) {
            return board[x][y] == word.charAt(start);
        }

        if (board[x][y] == word.charAt(start)) {
            isVisited[x][y] = true;
            for (int[] Direction : Directions) {
                int xNew = x + Direction[0];
                int yNew = y + Direction[1];
                // isVisited[xNew][yNew] == false 里面笔误写成 x 和 y 了
                if (inArea(xNew, yNew) && isVisited[xNew][yNew] == false) {
                    if (back(xNew, yNew, start + 1)) {
                        return true;
                    }
                }
            }
            isVisited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x < m && y < n && x >= 0 && y >= 0;
    }
}
