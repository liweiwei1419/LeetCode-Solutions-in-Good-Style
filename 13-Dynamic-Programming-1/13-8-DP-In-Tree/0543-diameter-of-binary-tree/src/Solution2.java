public class Solution2 {

    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }


    /**
     * @param node 以 root 为根结点的树的深度
     * @return 只保留一条边
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);

        // 只计算边，不加结点
        res = Math.max(res, leftPath + rightPath);

        // dp 的无后效性要求
        // 1、当前结点必须选
        // 2、左右选择其一

        // 要连接到自己，所以必须加 1
        return 1 + Math.max(leftPath, rightPath);
    }
}