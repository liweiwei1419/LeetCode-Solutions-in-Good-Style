import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        dfs(root, map, res);
        return res;
    }

    private String dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null) {
            return "";
        }

        // 前序遍历
        String curStr = "";
        curStr += node.val + ",";
        curStr += dfs(node.left, map, res) + ",";
        curStr += dfs(node.right, map, res);

        map.put(curStr, map.getOrDefault(curStr, 0) + 1);
        if (map.get(curStr) == 2) {
            res.add(node);
        }
        return curStr;
    }
}