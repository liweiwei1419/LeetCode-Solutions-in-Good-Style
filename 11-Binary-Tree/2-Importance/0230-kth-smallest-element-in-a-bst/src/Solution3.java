public class Solution3 {

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    private int count = 0;
    private int res = 0;

    private void dfs(TreeNode node) {
        // 先写递归终止条件
        if (node == null) {
            // 什么都不做
            return;
        }

        dfs(node.left);

        count--;
        if (count == 0) {
            this.res = node.val;
            // 这里写不写 return 都行，最好加上
            return;
        }

        dfs(node.right);
    }
}