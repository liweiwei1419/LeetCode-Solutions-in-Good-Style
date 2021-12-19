public class Solution4 {

    // 时间复杂度：O(N)，遍历数组
    // 空间复杂度：O(N)，存储二叉树

    private int index = 0;
    private int[] preorder;
    private int len;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        this.len = preorder.length;
        return dfs(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 通过下限和上限来控制指针移动的范围
     *
     * @param lowerBound
     * @param upperBound
     * @return
     */
    private TreeNode dfs(int lowerBound, int upperBound) {
        // 所有的元素都已经添加到了二叉树中
        if (index == len) {
            return null;
        }

        int cur = preorder[index];
        if (cur < lowerBound || cur > upperBound) {
            return null;
        }

        index++;
        TreeNode root = new TreeNode(cur);
        root.left = dfs(lowerBound, cur);
        root.right = dfs(cur, upperBound);
        return root;
    }
}