import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    // 方法二：广度优先遍历

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int len = digits.length();
        if (len == 0) {
            return res;
        }

        String[] digitsMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 注意：设置 res 的初始值为 ""，表示一开始从空串开始遍历
        res.add("");

        char[] charArray = digits.toCharArray();
        // 广度优先遍历的思路：新一轮在上一轮的基础末尾追加数字
        for (char c : charArray) {
            // 得到当前的数字，注意：减去偏移 `2`
            char[] nextArray = digitsMap[c - '2'].toCharArray();
            // cur 基于上一次 res 的结果追加生成，所以下面两个 for 循环，外层循环是 res，内层循环是 next
            List<String> cur = new ArrayList<>();
            for (String s : res) {
                for (char next : nextArray) {
                    cur.add(s + next);
                }
            }

            res = cur;
        }
        return res;
    }
}