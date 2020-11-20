import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    // 使用层序遍历

    public TreeNode invertTree(TreeNode root) {
        // 结点为空的特殊情况要先考虑
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            // 只要其中之一非空，我都交换，并且把非空的结点添加到队列里
            if (curNode.left != null || curNode.right != null) {
                // 先翻转
                TreeNode temp = curNode.left;
                curNode.left = curNode.right;
                curNode.right = temp;
                // 把非空的节点加入队列
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }
        return root;
    }
}