public class Solution3 {

    // 889. Construct Binary Tree from Preorder and Postorder Traversal
    // 1028 就是更难点的题目了

    int i = 0;

    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) {
            return null;
        }

        // 后序遍历
        TreeNode root = new TreeNode(A[i]);
        i++;
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}