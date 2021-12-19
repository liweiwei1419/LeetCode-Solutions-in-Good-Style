public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 这一步要特别注意，是一个很容易被忽略的情况
        if (root.left == null || root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}