public class Solution {

    // 根据左子树和右子树的深度来计算完全二叉树的结点个数

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root, true);
        int rightDepth = depth(root, false);
        // assert leftDepth >= rightDepth;
        if (leftDepth == rightDepth) {
            // 是完全二叉树
            return (1 << leftDepth) - 1;
        } else {
            // 1 是根结点计数
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    /**
     * 辅助函数
     *
     * @param root
     * @param isLeft 是否是左子树
     * @return
     */
    private int depth(TreeNode root, boolean isLeft) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = isLeft ? root.left : root.right;
        }
        return depth;
    }
}