import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    // 这里把 preorder 和 hashMap 声明成成员变量是为了减少一些参数传递，实际工作中需要根据组内要求和实际情况决定

    private int[] preorder;

    private Map<Integer, Integer> hashMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("输入数据有误。");
        }
        this.preorder = preorder;
        this.hashMap = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(0, preLen - 1, 0, inLen - 1);
    }

    private TreeNode buildTree(int preLeft, int preRight, int inLeft, int inRight) {
        // 因为是递归调用的方法，按照国际惯例，先写递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 先序遍历的起点元素很重要
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = hashMap.get(pivot);
        root.left = buildTree(preLeft + 1, pivotIndex - inLeft + preLeft,
                inLeft, pivotIndex - 1);
        root.right = buildTree(pivotIndex - inLeft + preLeft + 1, preRight,
                pivotIndex + 1, inRight);
        return root;
    }
}