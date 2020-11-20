import java.util.ArrayList;
import java.util.List;


public class Solution {

    private List<String> res = new ArrayList<>();

    private void sumNumbers(TreeNode node, String path) {
        if (node == null) {
            return;
        }

        path = path + node.val;
        if (node.left == null && node.right == null) {
            // 才是叶子节点，执行我们的逻辑
            res.add(path);
            return;
        }
        sumNumbers(node.left, path);
        sumNumbers(node.right, path);
    }

    private int convert() {
        int sum = 0;
        for (String s : res) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumNumbers(root, "");
        return convert();
    }
}