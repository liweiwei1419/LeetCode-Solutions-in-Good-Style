import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // 方法 2：用加法

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 这里的 dfs 是隐式回溯
        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号用了几个
     * @param right  右括号用了几个
     * @param n      左括号、右括号一共用几个
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        // 因为是递归函数，所以先写递归终止条件
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 如果左括号还没凑够，继续凑
        if (left < n) {
            // 拼接上一个左括号，并且剩余的左括号个数减 1
            dfs(curStr + "(", left + 1, right, n, res);
        }
        // 什么时候可以用右边？例如，(((((()，此时 left > right，
        // 不能用等号，因为只有先拼了左括号，才能拼上右括号
        if (right < n && left > right) {
            // 拼接上一个右括号，并且剩余的右括号个数减 1
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<String> res = solution2.generateParenthesis(3);
        System.out.println(res);
    }
}
