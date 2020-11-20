import java.util.ArrayDeque;
import java.util.Deque;

public class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        dfs(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void dfs(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append("#").append(",");
            return;
        }

        stringBuilder.append(node.val).append(",");
        dfs(node.left, stringBuilder);
        dfs(node.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len = data.length();
        if (len == 0) {
            return null;
        }
        String[] splits = data.split(",");

        Deque<String> queue = new ArrayDeque<>();
        for(String s:splits){
            queue.addLast(s);
        }
        return buildTree(queue);
    }


    private TreeNode buildTree(Deque<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String s = queue.removeFirst();
        if ("#".equals(s)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    //       1
    //     2   3
    //    4 5 6 7
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
//        TreeNode node1 = null;

        Codec2 codec = new Codec2();
        String serialize = codec.serialize(node1);
        System.out.println(serialize);

        codec.deserialize(serialize);
    }
}