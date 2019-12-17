/**
 * @author liweiwei1419
 * @date 2019/10/15 11:53 上午
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 这一步要特别注意，是一个很容易被忽略的情况
        if (root.left == null || root.right == null) {
            return Integer.max(minDepth(root.left), minDepth(root.right)) + 1;

        }
        return Integer.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
