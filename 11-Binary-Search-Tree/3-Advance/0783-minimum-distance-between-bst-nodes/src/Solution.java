import java.util.ArrayList;
import java.util.List;


public class Solution {

    // 我起初的思路是使用中续遍历，返回最小值

    public int minDiffInBST(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);

        int len = inOrderList.size();
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            ret = Math.min(ret, inOrderList.get(i + 1) - inOrderList.get(i));
        }
        return ret;
    }

    private void inOrder(TreeNode node, List<Integer> inOrderList) {
        if (node == null) {
            return;
        }
        inOrder(node.left, inOrderList);
        inOrderList.add(node.val);
        inOrder(node.right, inOrderList);
    }
}