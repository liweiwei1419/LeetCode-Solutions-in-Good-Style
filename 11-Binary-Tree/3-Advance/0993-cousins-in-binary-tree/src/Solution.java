import java.util.HashMap;
import java.util.Map;


public class Solution {

    // 深度优先遍历

    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> depth = new HashMap<>();
        Map<Integer, TreeNode> parent = new HashMap<>();

        // 结点 0 是一个特殊值，表示根结点
        dfs(root, 0, depth, parent);
        return depth.get(x).equals(depth.get(y)) && parent.get(x) != parent.get(y);

    }

    private void dfs(TreeNode currentNode,
                     int currentDepth,
                     Map<Integer, Integer> depth,
                     Map<Integer, TreeNode> parent) {

        depth.put(currentNode.val, currentDepth);

        if (currentNode.left != null) {
            dfs(currentNode.left, currentDepth + 1, depth, parent);
            parent.put(currentNode.left.val, currentNode);
        }

        if (currentNode.right != null) {
            dfs(currentNode.right, currentDepth + 1, depth, parent);
            parent.put(currentNode.right.val, currentNode);

        }
    }
}