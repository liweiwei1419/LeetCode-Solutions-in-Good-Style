import java.util.ArrayList;
import java.util.List;


public class Solution {

    // 回溯

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<String> path = new ArrayList<>();
        dfs(root, path, res);
        return res;
    }

    private void dfs(TreeNode node, List<String> path, List<String> res) {
        if (node == null) {
            return;
        }
        path.add("" + node.val);
        if (node.left == null && node.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                stringBuilder.append(path.get(i));
                stringBuilder.append("->");
            }
            stringBuilder.delete(stringBuilder.lastIndexOf("->"), stringBuilder.length());
            res.add(stringBuilder.toString());
            return;
        }

        if (node.left != null) {
            dfs(node.left, path, res);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            dfs(node.right, path, res);
            path.remove(path.size() - 1);
        }
    }
}