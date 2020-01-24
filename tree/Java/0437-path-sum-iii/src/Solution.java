class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {

    private int dfs(TreeNode root, int sum) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            // 后面的满足条件的路径之和为 0
            result++;
        }
        result += dfs(root.left, sum - root.val);
        result += dfs(root.right, sum - root.val);
        return result;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

}
