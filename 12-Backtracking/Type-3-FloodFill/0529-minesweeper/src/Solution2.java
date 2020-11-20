import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    // 方法二：广度优先遍历

    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    private int rows;
    private int cols;

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        this.rows = board.length;
        this.cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];
            int count = 0;
            for (int[] direction:directions) {
                int newX = i + direction[0];
                int newY = j + direction[1];
                if (inArea(newX,newY) &&board[newX][newY] == 'M') {
                    count++;
                }
            }

            if (count > 0) {
                board[i][j] = (char)(count + '0');
            } else {
                board[i][j] = 'B';
                for (int[] direction:directions) {
                    int newX = i + direction[0];
                    int newY = j + direction[1];
                    if (inArea(newX,newY) && !visited[newX][newY] && board[newX][newY] == 'E') {
                        visited[newX][newY] = true;
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }
        }
        return board;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}