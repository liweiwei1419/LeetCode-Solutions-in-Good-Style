import java.util.HashMap;
import java.util.Map;

/**
 * @author liweiwei1419
 * @date 2019/10/8 10:49 上午
 */
public class Solution5 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;

        if (inLen != postLen) {
            throw new RuntimeException("输入错误");
        }

        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            hash.put(inorder[i], i);
        }
        return buildTree(hash, 0, inLen - 1, postorder, 0, postLen - 1);
    }

    private TreeNode buildTree(Map<Integer, Integer> hash, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int pivot = postorder[postRight];
        int pivotIndex = hash.get(pivot);

        TreeNode root = new TreeNode(pivot);
        root.left = buildTree(hash, inLeft, pivotIndex - 1,
                postorder, postLeft, pivotIndex - 1 - inLeft + postLeft);
        root.right = buildTree(hash, pivotIndex + 1, inRight,
                postorder, pivotIndex - inLeft + postLeft, postRight - 1);
        return root;
    }
}
