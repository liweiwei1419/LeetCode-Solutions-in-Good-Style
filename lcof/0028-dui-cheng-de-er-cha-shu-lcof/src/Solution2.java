import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 实现类不能选用 ArrayDeque，因为该类的 add 方法会对添加的元素做非空检查
        Deque<TreeNode> deque = new LinkedList<>();
        // Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addFirst(root.left);
        deque.addLast(root.right);

        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.removeFirst();
            TreeNode rightNode = deque.removeLast();

            if (leftNode == null && rightNode == null) {
                continue;
            }

            if (leftNode == null || rightNode == null) {
                return false;
            }

            if (leftNode.val != rightNode.val) {
                return false;
            }

            deque.addFirst(leftNode.right);
            deque.addFirst(leftNode.left);
            deque.addLast(rightNode.left);
            deque.addLast(rightNode.right);
        }

        return true;
    }
}
