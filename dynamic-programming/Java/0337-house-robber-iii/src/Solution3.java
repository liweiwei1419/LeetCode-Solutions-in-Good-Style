public class Solution3 {

    // 树形 dp + 二叉树的后序遍历

    // 0 表示不打劫
    // 1 表示打劫

    public int rob(TreeNode root) {
        int[] res = tryRob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] tryRob(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = tryRob(root.left);
        int[] right = tryRob(root.right);

        int[] res = new int[2];
        // 根结点不打劫 = max(左子树不打劫, 左子树打劫) + max(右子树不打劫, 右子树打劫)
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 根结点打劫 = 左右孩子结点都不能打劫
        res[1] = left[0] + right[0] + root.val;

        return res;
    }
}
