class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return dfs(pRoot.left, pRoot.right);
    }

    private boolean dfs(TreeNode pRoot1, TreeNode pRoot2) {
        // 先写递归终止条件
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }

        // 如果其中之一为空，也不是对称的
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }

        // 走到这里二者一定不为空
        if (pRoot1.val != pRoot2.val) {
            return false;
        }
        // 前序遍历
        return dfs(pRoot1.left, pRoot2.right) && dfs(pRoot1.right, pRoot2.left);
    }
}