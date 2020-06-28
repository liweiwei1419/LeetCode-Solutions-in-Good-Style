
public class Solution3 {

    // 后序遍历
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}