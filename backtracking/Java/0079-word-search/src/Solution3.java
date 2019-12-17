import java.util.Stack;

/**
 * @author liwei
 * @date 2019/8/26 1:44 PM
 */
public class Solution3 {

    private int m;
    private int n;

    class Cell {
        // 横坐标
        private int x;
        // 纵坐标
        private int y;
        // 表示已经匹配到 word 的 index 位置
        private int index;

        public Cell(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public boolean exist(char[][] board, String word) {
        int len = word.length();
        // 盘面上有多少行
        this.m = board.length;
        if (m == 0) {
            return false;
        }
        // 盘面上有多少列
        this.n = board[0].length;
        //        x-1,y
        // x,y-1  x,y    x,y+1
        //        x+1,y
        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        // 一次性声明在迭代过程中需要的变量
        boolean[][] marked;
        Stack<Cell> stack;
        int index;
        int x;
        int y;
        Cell curCell;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // 进行一次深度优先遍历，每一次遍历栈的信息都得初始化
                    marked = new boolean[m][n];
                    stack = new Stack<>();
                    stack.push(new Cell(i, j, 0));

                    while (!stack.isEmpty()) {
                        // 注意：这里是 peek，在回溯的时候才弹栈
                        curCell = stack.peek();
                        x = curCell.x;
                        y = curCell.y;
                        index = curCell.index;

                        if (index == len - 1) {
                            // 因为进栈的单元格一定是匹配的单元格，只要匹配到最后一格，就可以返回了
                            return true;
                        }

                        if (marked[x][y]) {
                            // 这里是回溯，栈弹出，状态重置
                            stack.pop();
                            marked[x][y] = false;
                            continue;
                        }

                        // 尝试从当前坐标开始深度优先遍历，因此要占住这个位置
                        marked[x][y] = true;
                        for (int k = 0; k < 4; k++) {
                            int newX = x + direction[k][0];
                            int newY = y + direction[k][1];
                            if (inArea(newX, newY) && !marked[newX][newY]
                                    && board[newX][newY] == word.charAt(index + 1)) {
                                // 不越界，且不是之前使用过的字符，并且与下一个字符匹配
                                stack.push(new Cell(newX, newY, index + 1));
                                // push 进去就可以了，不要占住位置
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        Solution3 solution3 = new Solution3();
        boolean exist = solution3.exist(board, word);
        System.out.println(exist);
    }
}
