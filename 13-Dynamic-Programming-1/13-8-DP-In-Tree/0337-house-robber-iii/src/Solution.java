public class Solution {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        // 分类讨论的标准是：当前结点偷或者不偷
        // 需要后序遍历，所以先计算左右子结点，然后计算当前结点的状态值
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // dp[0]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点不偷
        // dp[1]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点偷
        int[] dp = new int[2];
        // 根结点不打劫 = max(左子树不打劫, 左子树打劫) + max(右子树不打劫, 右子树打劫)
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 根结点打劫 = 左右孩子结点都不能打劫
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }
}