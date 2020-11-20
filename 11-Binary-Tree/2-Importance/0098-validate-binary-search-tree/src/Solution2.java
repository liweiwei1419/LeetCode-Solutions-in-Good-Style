public class Solution2 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, null, null);
    }

    /**
     * @param node
     * @param leftBound
     * @param rightBound
     * @return
     */
    private boolean dfs(TreeNode node, Integer leftBound, Integer rightBound) {
        if (node == null) {
            return true;
        }

        // 在前序遍历的时候检查是否符合二叉搜索树的性质

        // 当左边界不为空的时候，当前结点的值应该严格大于 leftBound
        if (leftBound != null && node.val <= leftBound) {
            return false;
        }
        // 当右边界不为空的时候，当前结点的值应该严格小于 rightBound
        if (rightBound != null && node.val >= rightBound) {
            return false;
        }
        return dfs(node.left, leftBound, node.val) && dfs(node.right, node.val, rightBound);
    }
}