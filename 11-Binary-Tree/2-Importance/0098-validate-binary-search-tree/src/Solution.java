import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> res = new ArrayList<>();
        inOrder(root, res);

        int len = res.size();
        for (int i = 0; i < len - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left, res);
        res.add(treeNode.val);
        inOrder(treeNode.right, res);
    }
}