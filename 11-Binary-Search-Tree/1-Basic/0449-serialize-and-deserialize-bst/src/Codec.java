public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        dfs(root, stringBuilder);
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private void dfs(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        stringBuilder.append(node.val);
        stringBuilder.append(",");
        dfs(node.left, stringBuilder);
        dfs(node.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int len = data.length();
        if (len == 0) {
            return null;
        }
        String[] dataArray = data.split(",");
        return deserialize(dataArray, 0, dataArray.length - 1);
    }

    private TreeNode deserialize(String[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[left]));
        int index = right + 1;
        for (int i = left + 1; i <= right; i++) {
            if (Integer.parseInt(arr[i]) > root.val) {
                index = i;
                break;
            }
        }
        root.left = deserialize(arr, left + 1, index - 1);
        root.right = deserialize(arr, index, right);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));