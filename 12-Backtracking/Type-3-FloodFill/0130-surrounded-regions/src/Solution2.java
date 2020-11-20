import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    // 方法二：广度优先遍历

    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) {
            return;
        }
        int cols = board[0].length;

        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        // 第 1 步：把四周的 'O' 全部推入队列，通过广度优先遍历，把与 'O' 连通的地方全部编辑
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][cols - 1] == 'O') {
                queue.offer(new int[]{i, cols - 1});
            }
        }
        for (int j = 1; j < cols - 1; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new int[]{0, j});
            }
            if (board[rows - 1][j] == 'O') {
                queue.offer(new int[]{rows - 1, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int i = top[0];
            int j = top[1];
            board[i][j] = '-';
            for (int[] direction : directions) {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if (inArea(newX, newY, rows, cols) && board[newX][newY] == 'O') {
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        // 第 2 步：恢复
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}