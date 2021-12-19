import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(root1, res);
        dfs(root2, res);

        Collections.sort(res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        dfs(node.left, nums);
        nums.add(node.val);
        dfs(node.right, nums);
    }
}