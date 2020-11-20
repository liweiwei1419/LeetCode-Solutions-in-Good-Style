import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }

    private void dfs(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#").append(",");
            return;
        }
        builder.append(node.val).append(",");
        dfs(node.left, builder);
        dfs(node.right, builder);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 特判
        if (data.length() == 0) {
            return null;
        }

        // 特别要注意，这个方法在 "" 字符串的时候，会返回数组 [""]
        String[] split = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String str : split) {
            queue.offer(str);
        }
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String head = queue.poll();
        if ("#".equals(head)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(head));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));