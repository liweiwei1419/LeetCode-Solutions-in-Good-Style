import java.util.ArrayList;
import java.util.List;


public class Solution {

    // 思路：我们按照深度优先遍历的顺序，从右边开始遍历
    // 思路很像前、中、后序遍历（他们都是深度优先遍历），只不过我们先从右边开始遍历

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }


    private void dfs(TreeNode node, int level, List<Integer> res) {
        // 如果 node 为空，就直接返回，一定要先写，以减少很多判断
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(node.val);
        }
        // 如果交换下面两行的顺序，那么就得到二叉树的左视图
        dfs(node.right, level + 1, res);
        dfs(node.left, level + 1, res);
    }
}