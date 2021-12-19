public class Solution5 {

    char[][] board;
    boolean[][] vis;

    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        this.board = board;
        vis = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, word, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(int i, int j, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (!inArea(i, j) || board[i][j] != word.charAt(idx) || vis[i][j]) {
            return false;
        }

        vis[i][j] = true;
        if (dfs(i - 1, j, word, idx + 1)) {
            return true;
        }
        if (dfs(i, j - 1, word, idx + 1)) {
            return true;
        }
        if (dfs(i + 1, j, word, idx + 1)) {
            return true;

        }
        if (dfs(i, j + 1, word, idx + 1)) {
            return true;
        }
        vis[i][j] = false;
        return false;
    }

    boolean inArea(int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
