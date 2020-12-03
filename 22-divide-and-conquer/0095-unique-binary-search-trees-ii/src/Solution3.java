import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    // 在拷贝树，复杂度高

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new ArrayList[n + 1];
        res[0] = new ArrayList<>();
        if (n <= 0) {
            return res[0];
        }
        // 注意这个位置
        res[0].add(null);
        for (int i = 1; i <= n; i++) {
            // 先将对象数组初始化
            res[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (TreeNode left : res[j]) {
                    for (TreeNode right : res[i - j - 1]) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        res[i].add(root);
                    }
                }
            }
        }
        return res[n];
    }

    private TreeNode clone(TreeNode root, int k) {
        if (root == null) {
            return root;
        }
        TreeNode curNode = new TreeNode(root.val + k);
        curNode.left = clone(root.left, k);
        curNode.right = clone(root.right, k);
        return curNode;
    }
}