public class Solution {

    // 增加一维
    // 参考资料：https://leetcode-cn.com/problems/binary-tree-longest-consecutive-sequence-ii/solution/java-di-gui-by-zxy0917-12/

    private int res;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        // dp[0] 为递增序列路径数，dp[1] 为递减序列路径数
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        if (root == null) {
            return dp;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 判断 root 在左子树中处于递增还是递减
        if (root.left != null) {
            if (root.left.val - 1 == root.val) {
                dp[1] = left[1] + 1;
            }
            if (root.left.val + 1 == root.val) {
                dp[0] = left[0] + 1;
            }
        }

        // 判断 root 在右子树中处于递增还是递减，最后 dp 结果中保留最大值
        if (root.right != null) {
            if (root.right.val - 1 == root.val) {
                dp[1] = Math.max(dp[1], right[1] + 1);
            }
            if (root.right.val + 1 == root.val) {
                dp[0] = Math.max(dp[0], right[0] + 1);
            }
        }

        res = Math.max(res, dp[0] + dp[1] - 1);
        return dp;
    }
}