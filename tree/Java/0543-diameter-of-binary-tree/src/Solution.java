class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * Definition for a binary tree node.
 */
class Solution {

    // 后序遍历：先左右子树、然后处理自己
    // 将二叉树的直径转换为：二叉树的 每个节点的左右子树的高度和 的最大值

    private int res;

    /**
     * @param node 以 node 为根结点的子树的到叶子结点的路径的长度
     * @return
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);

        // 这里的 1 表示 node 自己
        res = Math.max(res, leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }
}
