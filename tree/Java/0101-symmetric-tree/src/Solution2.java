public class Solution2 {

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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2L = new TreeNode(2);
        TreeNode node2R = new TreeNode(2);
        TreeNode node3L = new TreeNode(3);
        TreeNode node3R = new TreeNode(3);

        node1.left = node2L;
        node1.right = node2R;

        node2L.right = node3L;
        node2R.right = node3R;

        Solution solution = new Solution();
        boolean symmetric = solution.isSymmetric(node1);
        System.out.println(symmetric);
    }
}
