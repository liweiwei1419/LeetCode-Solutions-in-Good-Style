public class Solution {

    private int res = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int longestLen = 1;
        if (node.left != null && node.left.val == node.val + 1) {
            longestLen = Math.max(longestLen, left + 1);
        }

        if (node.right != null && node.right.val == node.val + 1) {
            longestLen = Math.max(longestLen, right + 1);
        }

        res = Math.max(res, longestLen);
        return longestLen;
    }
}