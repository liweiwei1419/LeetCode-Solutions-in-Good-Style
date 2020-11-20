public class Solution {

    // 思路：分治思想、后序遍历

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