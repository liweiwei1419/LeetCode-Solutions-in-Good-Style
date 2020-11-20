public class Solution2 {

    // 889. Construct Binary Tree from Preorder and Postorder Traversal
    // 1028 就是更难点的题目了

    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        return buildBST(preorder, 0, len - 1);
    }

    /**
     * 使用 preorder 的子区间 [left, right] 构建二叉树
     *
     * @param preorder
     * @param left
     * @param right
     * @return
     */
    private TreeNode buildBST(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) {
            return root;
        }

        // [left + 1, right] 5 7 8 9
        // 重点逻辑：在区间 [left, right] 里找最后一个小于 preorder[left] 的下标
        // 注意这里设置区间的左边界为 left ，不能是 left + 1
        int leftPoint = left;
        int rightPoint = right;

        while (leftPoint < rightPoint) {
            int mid = leftPoint + (rightPoint - leftPoint + 1) / 2;
            // [3, 4]
            if (preorder[mid] < preorder[left]) {
                // 下一轮搜索区间是 [mid, rightPoint]
                leftPoint = mid;
            } else {
                // 下一轮搜索区间是 [left, mid - 1]
                rightPoint = mid - 1;
            }
        }
        // [leftPoint, rightPoint]
        TreeNode leftTree = buildBST(preorder, left + 1, leftPoint);
        TreeNode rightTree = buildBST(preorder, leftPoint + 1, right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}