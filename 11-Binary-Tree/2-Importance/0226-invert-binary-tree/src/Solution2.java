public class Solution2 {

    // 使用中序遍历

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 注意：因为左右子树已经交换了，因此这里不能写 invertTree(root.right);
        // 即：这里的 root.left 就是交换之前的 root.right
        invertTree(root.left);
        return root;
    }
}
