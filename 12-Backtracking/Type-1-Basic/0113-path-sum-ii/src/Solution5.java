import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution5 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, sum, path, res);
        return res;
    }

    public void dfs(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        sum -= node.val;
        path.addLast(node.val);

        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (node.left != null) {
            dfs(node.left, sum, path, res);
            path.removeLast();
        }

        if (node.right != null) {
            dfs(node.right, sum, path, res);
            path.removeLast();
        }
    }
}