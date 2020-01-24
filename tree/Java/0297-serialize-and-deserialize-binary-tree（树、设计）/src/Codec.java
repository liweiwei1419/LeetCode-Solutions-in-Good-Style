import java.util.Arrays;
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
        preOrder(root, builder);
        return builder.toString();
    }

    private void preOrder(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#");
            builder.append(",");
            return;
        }
        builder.append(node.val);
        builder.append(",");
        preOrder(node.left, builder);
        preOrder(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] split = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(split));
        return preOrder(queue);
    }

    private TreeNode preOrder(Queue<String> queue ) {
        if (queue.isEmpty()) {
            return null;
        }
        String s = queue.poll();
        if("#".equals(s)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = preOrder(queue);
        root.right =  preOrder(queue);
        return root;
    }



}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));