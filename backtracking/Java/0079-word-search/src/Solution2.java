
public class Solution2 {

    /**
     * 从"上"这个方向开始，顺时针旋转得到的 4 个方向，分别是，上，右，下，左
     * 4 个方向产生的位移（不要与 x 轴、y 轴坐标相混淆，这里自己画一张图就能明白）
     */
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m;// 表格有多少行
    int n;// 表格有多少列
    boolean[][] marked;

    char[][] board; // 单词表面板
    String word; // 待查找的单词


    // 指定的坐标是否在表格内
    private boolean inArea(int x, int y) {
        boolean inArea = x >= 0 && x < m && y >= 0 && y < n;
        return inArea;
    }


    public boolean exist(char[][] board, String word) {
        m = board.length; // 这个 board 有几行
        if (m == 0) {
            return false;
        }
        n = board[0].length; // 这个 board 有多少列
        marked = new boolean[m][n];
        this.board = board;
        this.word = word;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 从 board[startX][startY]
     *
     * @param index  当前遍历的 word 的起始单词
     * @param startX 起始点的横坐标
     * @param startY 起始点的纵坐标
     * @return
     */
    private boolean searchWord(int index, int startX, int startY) {
        // 循环终止条件，判断到最后一位
        if (index == word.length() - 1) {
            // 如果这个最后一位也符合 word 最后一位的字母，那么就返回了
            return board[startX][startY] == word.charAt(index);
        }

        // 如果当前在 word 中间的字符匹配，那么首先要做上标记

        if (board[startX][startY] == word.charAt(index)) {
            marked[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                // 如果没有越界，并且没有访问过，并且下一个是匹配的时候，才返回 true
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (searchWord(index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            marked[startX][startY] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[3][7];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = Integer.valueOf(String.valueOf(i) + String.valueOf(j));
            }

        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(nums.length);


        char[][] board = {{'A', 'G', 'D', 'D'},
                {'C', 'D', 'U', 'D'},
                {'F', 'C', 'I', 'I'},
                {'R', 'C', 'K', 'Y'}};

        System.out.println(board.length);

        String word = "AG";
        Solution solution = new Solution();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);


        char a = 'A';
        char b = 'A';
        System.out.println(a == b);

    }
}
