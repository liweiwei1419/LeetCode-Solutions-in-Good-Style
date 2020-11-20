public class Solution2 {

    private int sumNumbers(TreeNode node, int cumsum) {
        if (node == null) {
            return 0;
        }
        cumsum = 10 * cumsum + node.val;
        if (node.left == null && node.right == null) {
            return cumsum;
        }
        return sumNumbers(node.left, cumsum) + sumNumbers(node.right, cumsum);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }
}