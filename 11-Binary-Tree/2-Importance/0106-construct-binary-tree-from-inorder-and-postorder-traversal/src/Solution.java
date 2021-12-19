import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 让 postorder 成为全局变量，以免在递归方法中一直传递
     */
    private int[] postorder;
    private Map<Integer, Integer> hash;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;

        if (inLen != postLen) {
            throw new RuntimeException("输入错误");
        }

        this.postorder = postorder;
        hash = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            hash.put(inorder[i], i);
        }

        return buildTree(0, inLen - 1, 0, postLen - 1);
    }

    /**
     * 使用中序遍历序列 inorder 的子区间 [inLeft, inRight]
     * 与后序遍历序列 postorder 的子区间 [postLeft, postRight] 构建二叉树
     *
     * @param inLeft    中序遍历序列的左边界
     * @param inRight   中序遍历序列的右边界
     * @param postLeft  后序遍历序列的左边界
     * @param postRight 后序遍历序列的右边界
     * @return 二叉树的根结点
     */
    private TreeNode buildTree(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        int pivot = postorder[postRight];
        int pivotIndex = hash.get(pivot);
        TreeNode root = new TreeNode(pivot);
        root.left = buildTree(inLeft, pivotIndex - 1, postLeft, postRight - inRight + pivotIndex - 1);
        root.right = buildTree(pivotIndex + 1, inRight, postRight - inRight + pivotIndex, postRight - 1);
        return root;
    }
}