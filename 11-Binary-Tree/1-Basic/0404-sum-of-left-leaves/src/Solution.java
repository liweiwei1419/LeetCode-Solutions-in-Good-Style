public class Solution {

    // 后序遍历

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 表明 root 是叶子结点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            // 分治算法
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}