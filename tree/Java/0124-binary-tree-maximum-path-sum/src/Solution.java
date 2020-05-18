class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private int maxSum;

    // 后序遍历

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        maxSum = Math.max(maxSum,
                node.val + Math.max(0, left) + Math.max(0, right));
        return node.val + Math.max(0, Math.max(left, right));
    }
}
