public class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 分而治之
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    /**
     * @param root
     * @param sum 除了 root 以外，当前已经得到的路径之和
     * @return
     */
    private int dfs(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            // 后面的满足条件的路径之和为 0
            res++;
        }
        res += dfs(root.left, sum - root.val);
        res += dfs(root.right, sum - root.val);
        return res;
    }
}