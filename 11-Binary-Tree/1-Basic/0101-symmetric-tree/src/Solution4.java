public class Solution4 {

    // 同解法 2

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode newTreeNode = copyBinaryTree(root);
        return isSameTree(root, newTreeNode);
    }

    private boolean isSameTree(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null || p1.val != p2.val) {
            return false;
        }
        return isSameTree(p1.left, p2.left) && isSameTree(p1.right, p2.right);
    }

    private TreeNode copyBinaryTree(TreeNode node) {
        if (node == null) {
            return node;
        }
        TreeNode root = new TreeNode(node.val);
        root.left = copyBinaryTree(node.right);
        root.right = copyBinaryTree(node.left);
        return root;
    }
}