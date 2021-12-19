public class Solution2 {

    private int res;

    public int maxDepth(TreeNode root) {
        maxDepth(root, 1);
        return res;
    }

    private void maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }
}