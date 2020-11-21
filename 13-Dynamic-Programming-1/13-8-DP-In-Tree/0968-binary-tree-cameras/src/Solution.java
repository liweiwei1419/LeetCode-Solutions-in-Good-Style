public class Solution {

    private int count = 0;

    public int minCameraCover(TreeNode root) {
        int res = dfs(root);
        if (res == 2) {
            return count + 1;
        }
        return count;
    }

    /**
     * @param node
     * @return 0 该结点有一盏灯，可以点亮父亲结点
     * 1 该结点没有灯，孩子结点有灯
     * 2 该结点没有灯，孩子结点也没有灯
     */
    private int dfs(TreeNode node) {
        if (node == null) {
            return 1;
        }

        // 后序遍历
        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 2 || right == 2) {
            count++;

            // 难理解
            return 0;
        } else if (left == 0 || right == 0) {
            return 1;
        }
        return 2;
    }
}