import java.util.Arrays;


public class Solution3 {
    /**
     * @param inorder   中序遍历序列
     * @param postorder 后序遍历序列
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int inlen = inorder.length;
        int postlen = postorder.length;

        assert inlen == postlen;

        if (inlen == 0) {
            return null;
        }
        if (inlen == 1) {
            return new TreeNode(inorder[0]);
        }

        // 后序遍历的最后一个结点就是根结点
        int rootVal = postorder[postlen - 1];
        // 在中序遍历中找到根结点的索引，得到左右子树的一个划分
        int dividePoint = 0;
        for (int i = 0; i < inlen; i++) {
            if (inorder[i] == rootVal) {
                dividePoint = i;
                break;
            }
        }
        TreeNode rootNode = new TreeNode(rootVal);
        // Arrays.copyOfRange() 方法的第 1 个参数是源数组
        // 第 2 个参数是源数组的起始位置（可以取到）
        // 第 3 个参数是源数组的起始位置（不可以取到）
        // 这里复制了数组，使用了一些空间，因此空间复杂度是 O(N)
        rootNode.left = buildTree(Arrays.copyOfRange(inorder, 0, dividePoint), Arrays.copyOfRange(postorder, 0, dividePoint));
        rootNode.right = buildTree(Arrays.copyOfRange(inorder, dividePoint + 1, inlen), Arrays.copyOfRange(postorder, dividePoint, postlen - 1));
        return rootNode;
    }
}


