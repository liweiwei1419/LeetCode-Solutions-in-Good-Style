import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    private Map<TreeNode, Integer> memo;

    // Solution 方法 + 记忆化递归

    private int tryRob(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        int res = node.val;

        if (node.left != null) {
            res += tryRob(node.left.left) + tryRob(node.left.right);
        }

        if (node.right != null) {
            res += tryRob(node.right.left) + tryRob(node.right.right);
        }

        res = Math.max(res, tryRob(node.left) + tryRob(node.right));
        memo.put(node, res);
        return res;
    }

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return tryRob(root);
    }
}
