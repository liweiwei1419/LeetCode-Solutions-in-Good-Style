import java.util.ArrayList;
import java.util.List;

public class Solution6 {

    private int k;

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        this.k = k;
        dfs(root, res);
        return res.get(k - 1);
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        dfs(node.left, res);
        res.add(node.val);
        if (res.size() == k){
            return;
        }
        dfs(node.right, res);
    }
}