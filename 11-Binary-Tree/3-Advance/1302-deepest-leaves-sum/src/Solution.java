public class Solution {

    private int res;
    private int maxDepth;

    // 二叉树的前序遍历

    private void dfs(TreeNode node, int depth, boolean calculateSum) {
        if (node == null) {
            return;
        }

        maxDepth = Math.max(maxDepth, depth);

        if (calculateSum && maxDepth == depth) {
            res += node.val;
        }

        // 第 1 遍计算最大的深度
        dfs(node.left, depth + 1, calculateSum);
        // 第 2 遍计算叶子结点的和
        dfs(node.right, depth + 1, calculateSum);
    }

    public int deepestLeavesSum(TreeNode root) {
        res = 0;
        maxDepth = 0;
        dfs(root, 1, false);
        dfs(root, 1, true);
        return res;
    }
}