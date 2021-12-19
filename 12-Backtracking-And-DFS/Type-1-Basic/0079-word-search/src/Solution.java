public class Solution {

    private boolean[][] visited;
    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int cols;
    private int len;
    private char[] charArray;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        len = word.length();
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        visited = new boolean[rows][cols];
        this.charArray = word.toCharArray();
        this.board = board;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param i
     * @param j
     * @param begin 从 word[begin] 处开始搜索
     * @return
     */
    private boolean dfs(int i, int j, int begin) {
        // 字符串的最后一个字符匹配，即返回 true
        if (begin == len - 1) {
            return board[i][j] == charArray[begin];
        }

        // 只要当前考虑的字符能够匹配，就从四面八方继续搜索
        if (board[i][j] == charArray[begin]) {
            visited[i][j] = true;
            for (int[] direction : directions) {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}