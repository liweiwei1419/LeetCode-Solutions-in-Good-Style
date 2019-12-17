/**
 * @author liwei
 * @date 18/7/3 下午9:30
 */
public class Solution3 {

    // 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        assert root != null;
        // 如果没有左子树和右子树，就说明是根结点了
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        boolean hasPathSum = false;
        if (root.left != null) {
            hasPathSum = hasPathSum || hasPathSum(root.left, sum - root.val);
        }
        if (root.right != null) {
            hasPathSum = hasPathSum || hasPathSum(root.right, sum - root.val);
        }
        return hasPathSum;
    }
}
