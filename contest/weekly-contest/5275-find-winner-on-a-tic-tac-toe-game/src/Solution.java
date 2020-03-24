import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/12/1 10:47 上午
 */
public class Solution {
    // 暴力解法

    public String tictactoe(int[][] moves) {
        // 初始化棋盘
        int[][] board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }

        // A 下的地方赋值为 1，
        // B 下的地方赋值为 -1
        // 滚动变量，轮流给 A、B 赋值
        int cnt = 0;
        for (int[] position : moves) {
            if ((cnt & 1) == 0) {
                board[position[0]][position[1]] = 1;
            } else {
                board[position[0]][position[1]] = -1;
            }
            cnt++;
        }

        // 看每一行和每一列，双重循环中可以同时看
        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += board[i][j];
                colSum += board[j][i];
            }

            if (rowSum == 3 || colSum == 3) {
                return "A";
            }
            if (rowSum == -3 || colSum == -3) {
                return "B";
            }
        }

        // 主对角线
        int diagonal1 = 0;
        // 副对角线
        int diagonal2 = 0;
        for (int i = 0; i < 3; i++) {
            diagonal1 += board[i][i];
            diagonal2 += board[i][2 - i];
        }

        if (diagonal1 == 3 || diagonal2 == 3) {
            return "A";
        }
        if (diagonal1 == -3 || diagonal2 == -3) {
            return "B";
        }

        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }

    public static void main(String[] args) {
        int[][] moves = {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
        Solution solution = new Solution();
        String res = solution.tictactoe(moves);
        System.out.println(res);
    }
}
