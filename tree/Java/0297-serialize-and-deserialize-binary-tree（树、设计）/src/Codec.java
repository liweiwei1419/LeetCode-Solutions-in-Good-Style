import java.util.LinkedList;

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
        LinkedList<String> queue = new LinkedList<>();
        String[] split = data.split(",");
        for(String s:split){
            queue.addLast(s);
        }
        return preOrder(queue);
    }

    private TreeNode preOrder(LinkedList<String> queue ) {
        if (queue.isEmpty()) {
            return null;
        }
        String s = queue.removeFirst();
        if("#".equals(s)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = preOrder(queue);
        root.right =  preOrder(queue);
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

        Codec codec = new Codec();
        String serialize = codec.serialize(node1);
        System.out.println(serialize);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));