import java.util.LinkedList;

public class Solution3 {

    // 迭代的解法，即 BFS

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root.left);
        queue.addLast(root.right);
        while (!queue.isEmpty()) {
            // 出队的时候，看看是否有左右孩子，分别入队
            TreeNode leftNode = queue.pollFirst();
            TreeNode rightNode = queue.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null) {
                return false;
            }
            queue.addFirst(leftNode.right);
            queue.addFirst(leftNode.left);
            queue.addLast(rightNode.left);
            queue.addLast(rightNode.right);

            if (leftNode.val != rightNode.val) {
                return false;
            }
        }
        return true;
    }
}