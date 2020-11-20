public class Solution2 {

    // 反转以后再判断是否相同（仅供参考）

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode copyBinaryTree = copyBinaryTree(root);
        TreeNode invertBinaryTree = invertBinaryTree(copyBinaryTree);
        return isSameTree(root, invertBinaryTree);
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    private TreeNode invertBinaryTree(TreeNode node) {
        if (node == null) {
            return node;
        }
        invertBinaryTree(node.left);
        invertBinaryTree(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }

    // 也使用递归的方式完成（熟悉一下如何完成二叉树的复制）

    private TreeNode copyBinaryTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode newTreeNode = new TreeNode(node.val);
        newTreeNode.left = copyBinaryTree(node.left);
        newTreeNode.right = copyBinaryTree(node.right);
        return newTreeNode;
    }
}