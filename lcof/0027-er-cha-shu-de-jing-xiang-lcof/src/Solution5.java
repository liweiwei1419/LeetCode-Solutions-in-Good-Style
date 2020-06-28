import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution5 {

    // 层序遍历

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.removeLast();

            TreeNode temp =  top.left;
            top.left =  top.right;
            top.right = temp;

            if (top.left != null) {
                stack.offer(top.left);
            }
            if (top.right != null) {
                stack.offer(top.right);
            }
        }

        return root;
    }
}