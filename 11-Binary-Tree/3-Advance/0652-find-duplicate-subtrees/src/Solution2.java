import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        dfs(root, map, res);
        return res;
    }

    private StringBuilder dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null) {
            return new StringBuilder();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(node.val);
        stringBuilder.append(",");

        stringBuilder.append(dfs(node.left, map, res));
        stringBuilder.append(",");
        stringBuilder.append(dfs(node.right, map, res));

        map.put(stringBuilder.toString(), map.getOrDefault(stringBuilder.toString(), 0) + 1);
        if (map.get(stringBuilder.toString()) == 2) {
            res.add(node);
        }
        return stringBuilder;
    }
}