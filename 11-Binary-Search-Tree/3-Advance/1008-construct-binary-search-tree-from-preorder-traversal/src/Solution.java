public class Solution {

    // 889. Construct Binary Tree from Preorder and Postorder Traversal

    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        return buildBST(preorder, 0, len - 1);
    }

    /**
     * 使用 preorder 的子区间 [left, right] 构建二叉树
     *
     * @param preorder
     * @param left
     * @param right
     * @return
     */
    private TreeNode buildBST(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) {
            return root;
        }

        int i = left;
        while (i + 1 <= right && preorder[i + 1] < preorder[left]) {
            i++;
        }

        // 此时子区间 [left + 1..i] < preorder[left] 5 7 8 9
        //  [i + 1..right] > preorder[left]

        TreeNode leftTree = buildBST(preorder, left + 1, i);
        TreeNode rightTree = buildBST(preorder, i + 1, right);

        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}