public class Solution2 {

    /**
     * 记得要把新的子树的根结点返回回去
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            return node;
        }

        TreeNode cur = root;
        while (true) {
            if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            }
        }
        return root;
    }
}