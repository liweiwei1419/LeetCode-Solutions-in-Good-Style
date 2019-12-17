import java.util.ArrayList;
import java.util.List;


public class Solution3 {

    private List<Integer> result = new ArrayList<>();

    private void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        result.add(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }
}
