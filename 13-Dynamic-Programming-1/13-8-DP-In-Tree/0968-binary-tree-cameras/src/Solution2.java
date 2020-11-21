public class Solution2 {

    // 贪心：从最底下向上就能得到最小的相机个数
    // 后序遍历

    // 0 - 当前结点和子结点没有相机：当前结点就要放置相机；
    // 1 - 当前结点有相机，子结点没有相机；
    // 2 - 当前结点没有相机，子节点有相机。

    private int count = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            return count + 1;
        }
        return count;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            count++;
            return 1;
        } else if (left == 1 || right == 1) {
            return 2;
        } else {
            return 0;
        }
    }
}