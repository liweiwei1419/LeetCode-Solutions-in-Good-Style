import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution4 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {

            TreeNode top = stack.removeLast();
            res.add(top.val);
            if (top.right != null) {
                stack.addLast(top.right);
            }
            if (top.left != null) {
                stack.addLast(top.left);
            }
        }
        return res;
    }
}
