class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        longestUnivaluePath(root, res);
        return res[0];
    }

    /**
     * 途径 node 的相同结点的最长路径
     *
     * @param node
     * @param res
     * @return
     */
    private int longestUnivaluePath(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int l = longestUnivaluePath(node.left, res);
        int r = longestUnivaluePath(node.right, res);
        int pl = 0;
        int pr = 0;
        if (node.left != null && node.val == node.left.val) {
            pl = l + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            pr = r + 1;
        }
        // 这一步很关键，这一步在更新全局的 answer
        res[0] = Math.max(res[0], pl + pr);
        // 返回只能使用单边最长的额路径
        return Math.max(pl, pr);
    }
}