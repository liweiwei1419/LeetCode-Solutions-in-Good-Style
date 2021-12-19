import java.util.ArrayDeque;
import java.util.Deque;

public class Solution7 {

    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        for (int i = 1; i < len; i++) {
            // 将栈的最后一个元素作为父元素，并从下一个前序遍历的节点创建子节点
            TreeNode node = stack.peekLast();
            TreeNode currentNode = new TreeNode(preorder[i]);

            // 栈中小于当前节点值的元素全部出栈，当前节点连接到最后一个弹出栈的结点的右边
            while (!stack.isEmpty() && stack.peekLast().val < currentNode.val) {
                node = stack.removeLast();
            }

            if (node.val < currentNode.val) {
                node.right = currentNode;
            } else {
                node.left = currentNode;
            }
            stack.addLast(currentNode);
        }
        return root;
    }
}
