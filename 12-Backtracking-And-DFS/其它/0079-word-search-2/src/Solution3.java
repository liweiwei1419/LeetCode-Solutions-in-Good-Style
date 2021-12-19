public class Solution3 {

    private int rows;
    private int cols;
    private int wordlen;

    public boolean exist(char[][] board, String word) {
        rows = board[0].length;
        cols = board.length;
        wordlen = word.length();
        boolean[][] visited = new boolean[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= cols || j >= rows || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        if (index == wordlen - 1) {
            return true;
        }
        visited[i][j] = true;
        if (dfs(board, i + 1, j, word, index + 1, visited)) {
            return true;
        }
        if (dfs(board, i, j + 1, word, index + 1, visited)) {
            return true;
        }
        if (dfs(board, i - 1, j, word, index + 1, visited)) {
            return true;
        }
        if (dfs(board, i, j - 1, word, index + 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
