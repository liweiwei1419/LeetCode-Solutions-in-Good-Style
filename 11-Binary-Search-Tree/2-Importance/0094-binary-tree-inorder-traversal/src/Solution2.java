import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    // 二叉树的中序遍历

    public List<Integer> inorderTraversal(TreeNode root) {
        // 体会栈这个数据结构在中序遍历中发挥的作用

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            // 不断压入左边的孩子结点
            while (curNode != null) {
                stack.addLast(curNode);
                curNode = curNode.left;
            }
            TreeNode top = stack.removeLast();
            res.add(top.val);
            curNode = top.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;

        Solution2 solution2 = new Solution2();
        List<Integer> inorderTraversal = solution2.inorderTraversal(node1);
        System.out.println(inorderTraversal);
    }
}