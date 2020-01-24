public class Solution2 {

    int res = 0;
    int level = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode cur, int l) {
        if (cur == null) {
            return;
        }
        if (cur.left == null && cur.right == null) {
            if (l == level) {
                res += cur.val;
            } else if (l > level) {
                res = cur.val;
                level = l;
            }
        } else {
            dfs(cur.left, l + 1);
            dfs(cur.right, l + 1);
        }
    }
}