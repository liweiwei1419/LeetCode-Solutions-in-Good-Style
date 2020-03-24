import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    // 参考资料：https://mp.weixin.qq.com/s/xyVc47WbyuDdbSuAfz4hLw
    // 时间复杂度是 O(n)，但实际上比 O(n) 要快

    public boolean isValidSudoku(char[][] board) {
        // 创建散列表
        Map<Integer, boolean[]> map = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    // 字符的ASCII码 十进制
                    int index = board[i][j];

                    // 创建宫格标记
                    int k = i / 3 * 3 + j / 3;

                    // 空间换取时间
                    if (!map.containsKey(index)) {
                        // 27 个空间默认放 false
                        map.put(index, new boolean[27]);
                    }

                    // 获取散列表的值
                    boolean[] booleans = map.get(index);

                    if (booleans[i] || booleans[j + 9] || booleans[k + 18]) {
                        return false;
                    } else {
                        booleans[i] = true;
                        booleans[j + 9] = true;
                        booleans[k + 18] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution solution = new Solution();
        boolean res = solution.isValidSudoku(board);
        System.out.println(res);
    }
}
