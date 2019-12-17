class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 初始条件：只要等于其中之一，就返回自己，作为后序判断的依据
        // 既然是编写递归方法，首先先写出递归终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        // 先在左子树中找，p 和 q 的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 再在右子树中找，p 和 q 的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左边和右边两者都空，说明，p 和 q 分散在 root 的左右子树中
        if (left != null && right != null) {
            return root;
        }
        // 否则返回 left 和 right 中非空的那个
        return left == null ? right : left;
    }
}
