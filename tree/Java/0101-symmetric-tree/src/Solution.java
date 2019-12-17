class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 判断是否镜面对称
// 参考资料：http://blog.csdn.net/crazy1235/article/details/51541984

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    // 【技巧在于设置辅助函数】
    // 画出 4 层结构图就容易发现递归关系了
    // 【特别注意】递归比较的时候，跟结点的值一定要相等

    private boolean isSymmetric(TreeNode p1, TreeNode p2) {
        // 左右都为空，判为相等
        if (p1 == null && p2 == null) {
            return true;
        }
        // 走到这里左右之一至少非空，或者都非空，但它们的 val 不等，都不能叫做 symmetric tree
        if (p1 == null || p2 == null || p1.val != p2.val) {
            return false;
        }
        // 对称地去比较，p1 的左边和 p2 的右边
        // p1 的右边和 p2 的左边
        return isSymmetric(p1.left, p2.right) && isSymmetric(p1.right, p2.left);
    }

}
