import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 递归（分治思想）

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            // 上层调用的方法须要这个空结点作为其左结点或者右节点
            res.add(null);
            return res;
        }
        if (left == right) {
            // 只有一个结点，这个结点作为根结点返回即可
            // 这一步可以包括到下面一个情况中
            res.add(new TreeNode(left));
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = generateTrees(left, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, right);
            for (TreeNode leftTree : leftList) {
                for (TreeNode rightTree : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}