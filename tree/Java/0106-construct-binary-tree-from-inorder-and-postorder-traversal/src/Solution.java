class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        // 特判
        if (inLen != postLen) {
            throw new RuntimeException("输入错误");
        }
        return buildTree(inorder, 0, inLen - 1, postorder, 0, postLen - 1);
    }

    /**
     * 使用中序遍历序列 inorder 的子区间 [inLeft, inRight]
     * 与后序遍历序列 postorder 的子区间 [postLeft, postRight] 构建二叉树
     *
     * @param inorder   中序遍历序列
     * @param inLeft    中序遍历序列的左边界
     * @param inRight   中序遍历序列的右边界
     * @param postorder 后序遍历序列
     * @param postLeft  后序遍历序列的左边界
     * @param postRight 后序遍历序列的右边界
     * @return 二叉树的根结点
     */
    private TreeNode buildTree(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        int pivot = postorder[postRight];
        int pivotIndex = inLeft;

        // 注意这里如果编写不当，有数组下标越界的风险
        while (inorder[pivotIndex] != pivot) {
            pivotIndex++;
        }
        TreeNode root = new TreeNode(pivot);
        root.left = buildTree(inorder, inLeft, pivotIndex - 1,
                postorder, postLeft, postRight - inRight + pivotIndex - 1);

        root.right = buildTree(inorder, pivotIndex + 1, inRight,
                postorder, postRight - inRight + pivotIndex, postRight - 1);
        return root;
    }
}
