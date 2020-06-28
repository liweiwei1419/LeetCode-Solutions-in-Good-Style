import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.addLast(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.removeLast();
            res.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return res;
    }

}
