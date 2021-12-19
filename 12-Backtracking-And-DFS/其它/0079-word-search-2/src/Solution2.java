public class Solution2 {

    // 辅助偏移数组:顺序定位（左上-右下）
    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // visited数组
    boolean[][] visited;

    int r;
    int c;

    public boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;

        visited = new boolean[r][c];//默认都是false；
        // 转换成字符数组，可以避免 charAt() 方法去判断下标有效性，但是对于这个问题没有显著提升
        char[] charArray = word.toCharArray();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (searchWord(board, charArray, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, char[] charArray, int index, int x, int y) {
        if (index == charArray.length - 1) {
            return board[x][y] == charArray[index];
        }

        if (board[x][y] == charArray[index]) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newx = x + d[i][0];
                int newy = y + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy] &&
                        searchWord(board, charArray, index + 1, newx, newy)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
