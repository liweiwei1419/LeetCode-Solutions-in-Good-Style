import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution6 {

    // 选用

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, path, sum, res);
        return res;
    }

    private void dfs(TreeNode node, Deque<Integer> path, int sum, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        path.addLast(node.val);

        if (node.left == null && node.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
        }

        if (node.left != null) {
            dfs(node.left, path, sum, res);
            path.removeLast();
        }

        if (node.right != null) {
            dfs(node.right, path, sum, res);
            path.removeLast();
        }
    }
}