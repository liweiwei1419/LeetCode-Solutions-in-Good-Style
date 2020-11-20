public class Solution {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootSaved = dfs(root, 0, limit);
        if (!rootSaved) {
            return null;
        }
        return root;
    }

    /**
     * @param node
     * @param s
     * @param limit
     * @return 返回 node 结点是否被保留（注意：这个返回值的意义，直接影响整个逻辑。）
     */
    private Boolean dfs(TreeNode node, int s, int limit) {
        if (node.left == null && node.right == null) {
            return s + node.val >= limit;
        }

        // 注意：如果 dfs 的返回值的意义是这个结点是否被保留，它们的默认值应该设置为 false
        boolean lTreeSaved = false;
        boolean rTreeSaved = false;

        // 如果有左子树，就先递归处理左子树
        if (node.left != null) {
            lTreeSaved = dfs(node.left, s + node.val, limit);
        }
        // 如果有右子树，就先递归处理右子树
        if (node.right != null) {
            rTreeSaved = dfs(node.right, s + node.val, limit);
        }

        // 左右子树是否保留的结论得到了，由自己来执行是否删除它们
        if (!lTreeSaved) {
            node.left = null;
        }
        if (!rTreeSaved) {
            node.right = null;
        }

        // 左右子树有一颗被保留，自己就应该被保留
        return lTreeSaved || rTreeSaved;
    }
}