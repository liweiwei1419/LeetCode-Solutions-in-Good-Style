/**
 * 既然标记为简单的问题，应该直觉想到的就是问题的解，且没有陷阱
 * https://leetcode-cn.com/problems/path-sum/description/
 */

public class Solution4 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // root 不为空，并且左边和右边至少有一个有值
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
