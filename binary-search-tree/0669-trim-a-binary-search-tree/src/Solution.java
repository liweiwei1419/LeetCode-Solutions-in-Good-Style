class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    // 这道题其实还蛮有意思的

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val >= L && root.val <= R) {
            root.left = trimBST(root.left, L, root.val);
            root.right = trimBST(root.right, root.val, R);
            return root;
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        assert root.val < L;
        return trimBST(root.right, L, R);
    }
}