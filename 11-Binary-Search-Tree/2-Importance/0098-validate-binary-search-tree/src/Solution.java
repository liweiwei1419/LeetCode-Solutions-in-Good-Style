public class Solution {

    public boolean isValidBST(TreeNode root) {
        // 依据定义
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.val, true) &&
                dfs(root.right, root.val, false) &&
                isValidBST(root.left) && isValidBST(root.right);
    }

    /**
     * @param node   当前结点
     * @param val    父亲结点的值
     * @param ifLeft 表示传入的结点是否是左结点
     * @return
     */
    private boolean dfs(TreeNode node, int val, boolean ifLeft) {
        if (node == null) {
            return true;
        }
        if (ifLeft) {
            if (node.val >= val) {
                return false;
            }
            return dfs(node.left, val, true) && dfs(node.right, val, true);
        } else {
            if (node.val <= val) {
                return false;
            }
            return dfs(node.left, val, false) && dfs(node.right, val, false);
        }
    }
}
