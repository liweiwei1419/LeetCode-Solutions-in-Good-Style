public class Solution {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int cur) {
        // 把数组下标越界的地方提前
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(cur)) {
            return false;
        }

        // 递归终止条件，cur 遍历到 word 的最后一个字符的时候，只需要看当前棋盘的字符是不是 word 的最后一个字符，然后返回
        if (cur == word.length() - 1) {
            return board[i][j] == word.charAt(word.length() - 1);
        }

        char tmp = board[i][j];
        board[i][j] = '*';
        if (dfs(board, i - 1, j, word, cur + 1) ||
                dfs(board, i, j + 1, word, cur + 1) ||
                dfs(board, i + 1, j, word, cur + 1) ||
                dfs(board, i, j - 1, word, cur + 1)) {
            return true;
        }
        board[i][j] = tmp;
        return false;
    }
}