public class Solution2 {

    private TreeNode preNode;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (preNode != null) {
            // 让左连接都失效
            preNode.left = null;
            preNode.right = root;
        }

        preNode = root;

        // 这一点比较难想到
        TreeNode temp = root.right;

        flatten(root.left);
        flatten(temp);
    }
}