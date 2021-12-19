public class Solution4 {

    private int len;
    private int wid;
    private int wordlen;

    public boolean exist(char[][] board, String word) {
        len = board[0].length - 1;
        wid = board.length - 1;
        wordlen = word.length();
        boolean[][] b = new boolean[wid + 1][len + 1];
        for (int i = 0; i <= wid; i++) {
            for (int j = 0; j <= len; j++) {
                if (dfs(board, i, j, word, 0, b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] b) {
        if (i < 0 || j < 0 || i > wid || j > len || board[i][j] != word.charAt(index) || b[i][j]) {
            return false;
        } else if (index + 1 == wordlen) {
            return true;
        }
        b[i][j] = true;
        if (dfs(board, i + 1, j, word, index + 1, b)) {
            return true;
        }
        if (dfs(board, i, j + 1, word, index + 1, b)) {
            return true;
        }
        if (dfs(board, i - 1, j, word, index + 1, b)) {
            return true;
        }
        if (dfs(board, i, j - 1, word, index + 1, b)) {
            return true;
        }
        b[i][j] = false;
        return false;
    }
}
