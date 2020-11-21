public class Solution {

    // 后序遍历：先左右子树、然后处理自己，将二叉树的直径转换为：二叉树的 每个节点的左右子树的高度和的最大值
    // 注意：两结点之间的路径长度是以它们之间边的数目表示。

    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    /**
     * 注意体会：以 node 为根结点的子树，体现无后效性
     *
     * @param node 以 node 为根结点的子树的到叶子结点的路径的长度
     * @return
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);

        res = Math.max(res, leftPath + rightPath);
        // 这里的 1 表示 node 自己
        return Math.max(leftPath, rightPath) + 1;
    }
}