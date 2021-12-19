import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.pollLast();
            stack.addFirst(node.val);
            if (node.left != null) {
                dq.addLast(node.left);
            }
            if (node.right != null) {
                dq.addLast(node.right);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.poll());
        }
        return res;
    }
}