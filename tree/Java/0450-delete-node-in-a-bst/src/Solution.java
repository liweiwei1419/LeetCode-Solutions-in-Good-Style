class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 用后继结点（子树）代替被删除结点

public class Solution {

    private TreeNode minNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 删除一个二分搜索树中最小的节点，把新的二分搜索树的根返回回去
     * 使用递归，要特别注意，定义的递归函数，返回的是，删除了最小值结点以后的新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            // 就是那个我们要删除的节点
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            // 如果待删除的节点左孩子为空
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            // 如果待删除的节点只有右孩子
            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
            // 从它的右子树中拿到最小的
            TreeNode successor = new TreeNode(minNode(root.right).val);
            successor.left = root.left;
            successor.right = removeMin(root.right);
            root.left = null;
            root.right = null;
            return successor;
        }
    }
}
