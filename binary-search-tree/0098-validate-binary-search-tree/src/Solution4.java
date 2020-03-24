import java.util.ArrayList;

public class Solution4 {
    /**
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        // 特判
        if (root == null) {
            return true;
        }
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int len = list.size();
        for (int i = 0; i < len - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // 中序遍历
    private void inOrder(TreeNode treeNode, ArrayList<Integer> list) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left, list);
        list.add(treeNode.val);
        inOrder(treeNode.right, list);
    }
}