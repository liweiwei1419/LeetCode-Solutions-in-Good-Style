class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 先处理最特殊的情况，都为空结点的时候
        if (p == null && q == null) {
            return true;
        }
        // 走到这里说明两个结点都同时不为空，那么其中之一为空，或者两个结点的值不相等的时候，返回 false
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
