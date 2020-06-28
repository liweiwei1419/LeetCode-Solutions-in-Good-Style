
public class Solution2 {

    // 中序遍历
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        mirrorTree(root.left);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;


        mirrorTree(root.left);

        return root;
    }


}