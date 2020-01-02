class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    // 这种做法会产生很多重复子问题

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = root.val;

        if (root.left != null) {
            res += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            res += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(res, rob(root.left) + rob(root.right));
    }
}