public class Solution2 {

    public int minDiffInBST(TreeNode root) {
        // 设置为 Integer 是为了检测出没有赋值的情况
        Integer[] preVal = new Integer[1];
        int[] ret = new int[]{Integer.MAX_VALUE};
        inOrder(root,preVal,ret);
        return ret[0];
    }

    private void inOrder(TreeNode node, Integer[] preVal, int[] ret) {
        if (node == null) {
            return;
        }
        inOrder(node.left, preVal, ret);
        if (preVal[0] != null) {
            int diff = node.val - preVal[0];
            ret[0] = Math.min(ret[0], diff);
        }
        // 注意，在这个位置更新之前的值
        preVal[0] = node.val;
        inOrder(node.right, preVal, ret);
    }
}