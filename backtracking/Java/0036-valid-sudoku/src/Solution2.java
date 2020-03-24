import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    // 作者：pphdsny
    // 链接：https://leetcode-cn.com/problems/valid-sudoku/solution/36-you-xiao-de-shu-du-javaha-xi-biao-by-pphdsny/

    public boolean isValidSudoku(char[][] board) {
        Map<String, Boolean> map = new HashMap<>();
        // hashmap 中存储的 key 有三种：行的 index + 数字、列的 index + 数字、3*3 宫格的 index + 数字
        // 在双重遍历中得匹配之前的遍历结果，看是否有重复的数字，考虑用 hashmap 保存遍历结果。
        // 所有的点都得遍历到，所以得双重遍历
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                String rowKey = i + "row" + num;
                String colKey = j + "col" + num;
                int groupIndex = i / 3 + j / 3 * 3;
                String groupKey = groupIndex + "group" + num;
                // 寻找是否有重复的数字
                if (map.getOrDefault(rowKey, false)
                        || map.getOrDefault(colKey, false)
                        || map.getOrDefault(groupKey, false)) {
                    return false;
                }
                // 更新遍历记录
                map.put(rowKey, true);
                map.put(colKey, true);
                map.put(groupKey, true);
            }
        }
        return true;
    }
}
