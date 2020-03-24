public class Solution2 {

    private boolean dfs(TreeNode node, int val, boolean ifLeft) {
        if (node == null) {
            return true;
        }
        if (ifLeft) {
            return node.val < val && dfs(node.left, val, ifLeft) && dfs(node.right, val, ifLeft);
        } else {
            return node.val > val && dfs(node.left, val, ifLeft) && dfs(node.right, val, ifLeft);

        }
    }

    /**
     * 按照 BST 的定义
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.val, true) &&
                dfs(root.right, root.val, false) &&
                isValidBST(root.left) && isValidBST(root.right);
    }
}
