public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 已任意 board[i][j] 为检索起点
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int position, String word) {
        if (i < 0
                || j < 0
                || i >= board.length
                || j >= board[0].length
                || position > word.length() - 1
                || board[i][j] != word.charAt(position)) {
            return false;
        }

        if (position >= word.length() - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '-';
        boolean result = dfs(board, i - 1, j, position + 1, word)
                || dfs(board, i + 1, j, position + 1, word)
                || dfs(board, i, j - 1, position + 1, word)
                || dfs(board, i, j + 1, position + 1, word);
        board[i][j] = tmp;
        return result;
    }
}
