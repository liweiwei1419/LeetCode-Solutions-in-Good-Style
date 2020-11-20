public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 这一句特别重要，如果左边和右边都非空，把当前结点返回回去
        if (left != null && right != null) {
            return root;
        }

        // 下面的这种写法包含了 left 和 right 同时为空的情况
        if (left == null) {
            return right;
        }
        return left;
    }
}