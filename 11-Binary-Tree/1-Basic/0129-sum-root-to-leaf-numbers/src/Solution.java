public class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int preSum) {
        if (node == null) {
            return 0;
        }
        preSum = 10 * preSum + node.val;
        if (node.left == null && node.right == null) {
            return preSum;
        }
        return dfs(node.left, preSum) + dfs(node.right, preSum);
    }
}