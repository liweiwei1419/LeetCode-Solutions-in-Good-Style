import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    // 思路：我们按照深度优先遍历的顺序，从右边开始遍历
    // 思路很像前、中、后序遍历（他们都是深度优先遍历），只不过我们先从右边开始遍历

    private void dfs(TreeNode node, int level) {
        // 如果 node 为空，就直接返回，一定要先写，以减少很多判断
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(node.val);
        }
        // 如果交换下面两行的顺序，那么就得到二叉树的左视图
        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode4;

        Solution solution = new Solution();
        List<Integer> rightSideView = solution.rightSideView(treeNode1);
        System.out.println(rightSideView);
    }
}
