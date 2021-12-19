public class Solution6 {

    public int row;
    public int col;
    public int n;
    public boolean flag = false;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        if (word.length() == 0 || word == "") {
            return true;
        }
        n = word.length();
        char[] ch = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == ch[0]) {
                    dfs(board, visited, ch, i, j, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board, boolean[][] visited, char[] ch, int x, int y, int index) {
        if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y] ||
                board[x][y] != ch[index]) {
            return;
        }
        visited[x][y] = true;
        if (index == n - 1) {
            flag = true;
            return;
        }
        dfs(board, visited, ch, x - 1, y, index + 1);
        dfs(board, visited, ch, x + 1, y, index + 1);
        dfs(board, visited, ch, x, y - 1, index + 1);
        dfs(board, visited, ch, x, y + 1, index + 1);
        visited[x][y] = flag;
        // visited[x][y] = false;
    }
}
