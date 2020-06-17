import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution3 {

    public List<List<Integer>> dfs(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // Java 文档中 Stack 类建议使用 Deque 代替 Stack，注意：只使用栈的相关接口
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, sum, path, res);
        return res;
    }

    private void dfs(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (node.val == sum && node.left == null && node.right == null) {
            path.addLast(node.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.addLast(node.val);
        dfs(node.left, sum - node.val, path, res);
        dfs(node.right, sum - node.val, path, res);
        path.removeLast();
    }
}
