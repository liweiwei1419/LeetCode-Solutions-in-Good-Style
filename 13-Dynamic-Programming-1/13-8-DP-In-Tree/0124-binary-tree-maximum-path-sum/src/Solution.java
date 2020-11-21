public class Solution {

    // 树形 dp + 后序遍历，在遍历的过程中找到题目要求的最值

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }


    /**
     * @param node 返回的答案里 node 必须被选取，且路径只有一边，这是 dp 的无后效性应用
     * @return
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 注意 1：后序遍历 + 剪枝，把从下到上路径和为 0 的枝叶剪去
        int leftPathSum = Math.max(0, dfs(node.left));
        int rightPathSum = Math.max(0, dfs(node.right));

        // 在遍历的过程中找到题目要求的最大路径和
        res = Math.max(res, node.val + leftPathSum + rightPathSum);

        // 注意 2：这里是 dp 的思想（无后效性），node.val 必须被选取，且左右路径只选一条
        return node.val + Math.max(leftPathSum, rightPathSum);
    }
}