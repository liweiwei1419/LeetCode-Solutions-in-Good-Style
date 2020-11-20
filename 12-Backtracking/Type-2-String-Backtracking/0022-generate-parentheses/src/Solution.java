import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 方法一：回溯算法（使用字符串拼接）

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(n, n, "", res);
        return res;
    }

    /**
     * @param left  左括号还有几个可以使用
     * @param right 右括号还有几个可以使用
     * @param path  每一次尝试，都生成新的字符串变量，无需回溯
     * @param res   结果集
     */
    private void dfs(int left, int right, String path, List<String> res) {
        // 如果左括号和右括号都用完了，添加到结果集
        if (left == 0 && right == 0) {
            res.add(path);
            return;
        }

        // 如果左括号还有可以使用的，就继续使用左括号
        if (left > 0) {
            dfs(left - 1, right, path + "(", res);
        }
        // 剩余左括号的个数严格小于右括号的个数的时候，才可以使用右括号
        if (left < right) {
            dfs(left, right - 1, path + ")", res);
        }
    }
}