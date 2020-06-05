import java.util.Arrays;

// 29 顺时针打印矩阵
// 参考资料：https://www.nowcoder.com/questionTerminal/9b4c81a02cd34f76be2659fa0d54342a
public class Solution {

    private enum State {
        // 右
        RIGHT,
        // 下
        DOWN,
        // 左
        LEFT,
        // 上
        UP
    }

    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return new int[0];
        }
        int cols = matrix[0].length;

        int[] res = new int[rows * cols];

        int rowMin = 0;
        int colMin = 0;
        // 上面的代码虽然看起来行数比较多，但是其实只是做了极端情况的考虑和一些变量的初始化工作

        // 下面的代码虽然看起来比较长，但是也只是做了当前状态的判断以及状态转移，代码框架是一模一样的
        // 仔细体会这个过程，其实就是：每次接收一个状态，根据这个状态做出相应的操作，然后变更状态
        State state = State.RIGHT;
        int i = 0;
        int j = 0;

        int index = 0;
        while (rowMin < rows && colMin < cols) {
            if (state == State.RIGHT) {
                while (j < cols) {
                    res[index] = matrix[i][j];
                    index++;
                    j++;
                }
                j--;
                i++;
                state = State.DOWN;
                rowMin++;
            } else if (state == State.DOWN) {
                while (i < rows) {
                    res[index] = matrix[i][j];
                    index++;
                    i++;
                }
                i--;
                j--;
                state = State.LEFT;
                cols--;
            } else if (state == State.LEFT) {
                while (j >= colMin) {
                    res[index] = matrix[i][j];
                    index++;
                    j--;
                }
                j++;
                i--;
                state = State.UP;
                rows--;
            } else {
                while (i >= rowMin) {
                    res[index] = matrix[i][j];
                    index++;
                    i--;
                }
                i++;
                j++;
                state = State.RIGHT;
                colMin++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int[][] matrix = new int[5][6];
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(count + "\t");
                matrix[i][j] = count;
                count++;
            }
            System.out.println();
        }
        Solution solution = new Solution();
        int[] res = solution.spiralOrder(matrix);
        System.out.println(Arrays.toString(res));
    }
}
