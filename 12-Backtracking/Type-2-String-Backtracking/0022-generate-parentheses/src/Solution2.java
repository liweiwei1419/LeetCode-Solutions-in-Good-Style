import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // 方法二：回溯算法（使用 StringBuilder ，有重置操作）

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        dfs(n, n, path, res);
        return res;
    }

    /**
     * @param left  左括号还有几个可以使用
     * @param right 右括号还有几个可以使用
     * @param path  从根结点到叶子结点的路径变量
     * @param res   结果集
     */
    private void dfs(int left, int right, StringBuilder path, List<String> res) {
        // 如果左括号和右括号都用完了，添加到结果集
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }

        // 如果左括号还有可以使用的，就继续使用左括号
        if (left > 0) {
            path.append("(");
            dfs(left - 1, right, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        // 剩余左括号的个数严格小于右括号的个数的时候，才可以使用右括号
        if (left < right) {
            path.append(")");
            dfs(left, right - 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}