import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    /**
     * 使用层序遍历
     *
     * @param root
     * @return
     */
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;
        TreeNode invertTree = solution.invertTree(node4);
        System.out.println(invertTree);
    }
}
