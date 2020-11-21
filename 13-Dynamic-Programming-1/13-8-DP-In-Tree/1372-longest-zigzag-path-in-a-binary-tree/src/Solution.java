public class Solution {

    // dp[0] 表示当前节点下一步向左走带来的最大收益；
    // dp[1] 表示当前节点下一步向右走带来的最大收益
    // dp[0] = 1 + dp[1] 当前结点下一步向左走带来的最大收益等于左子结点向右走的最大收益 + 1
    // dp[1] = 1 + dp[0] 当前结点下一步向右走带来的最大收益等于右子结点向左走的最大收益 + 1
    // 维护一个全局变量 res，每次遍历某一结点时，更新它

    private int res = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return res;
    }


    private int[] dfs(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) {
            dp[0] = -1;
            dp[1] = -1;
            return dp;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        dp[0] = 1 + left[1];
        dp[1] = 1 + right[0];
        res = Math.max(res, Math.max(dp[0], dp[1]));
        return dp;
    }
}