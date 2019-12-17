
// 用前驱结点（子树）代替被删除结点
public class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        assert key == root.val;

        if (root.left == null) {
            TreeNode right = root.right;
            root.right = null;
            return right;
        }

        if (root.right == null) {
            TreeNode left = root.left;
            root.left = null;
            return left;
        }
        TreeNode predecessor = maximum(root.left);
        TreeNode predecessorCopy = new TreeNode(predecessor.val);
        predecessorCopy.left = removeMax(root.left);
        predecessorCopy.right = root.right;
        root.left = null;
        root.right = null;
        return predecessorCopy;
    }

    private TreeNode removeMax(TreeNode node) {
        if (node.right == null) {
            TreeNode left = node.left;
            node.left = null;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private TreeNode maximum(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }
}