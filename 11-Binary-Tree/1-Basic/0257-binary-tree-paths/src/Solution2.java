import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // 字符串拼接

    private void dfs(TreeNode node, String pre, List<String> res) {
        // 递归终止条件：走到根节点的时候，就可以把沿途积累的字符串添加到结果集中
        if (node.left == null && node.right == null) {
            res.add(pre + node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, pre + node.val + "->", res);
        }
        if (node.right != null) {
            dfs(node.right, pre + node.val + "->", res);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        // 将全局的结果保存在这里
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, "", res);
        return res;
    }
}