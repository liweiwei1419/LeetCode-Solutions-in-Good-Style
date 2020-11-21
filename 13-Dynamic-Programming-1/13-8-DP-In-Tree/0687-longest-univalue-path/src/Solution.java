public class Solution {

    private int res;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    /**
     * 途径 node 的相同结点的最长路径
     *
     * @param node
     * @return
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftPath = 0;
        int rightPath = 0;
        if (node.left != null && node.val == node.left.val) {
            leftPath = left + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            rightPath = right + 1;
        }
        res = Math.max(res, leftPath + rightPath);
        // 返回只能使用单边最长的路径
        return Math.max(leftPath, rightPath);
    }
}