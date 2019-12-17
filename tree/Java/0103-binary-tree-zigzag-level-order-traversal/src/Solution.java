import java.util.ArrayList;
import java.util.LinkedList;
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

    private List<List<Integer>> res;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean direction = true;
        while (!queue.isEmpty()) {
            // 当前这一层遍历的节点集合
            List<Integer> curList = new ArrayList<>();

            // 特别注意：每一次只能处理上一轮入队列的的元素，
            // 所以要将上一轮入队列的元素个数先存一下
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.pop();
                if (direction) {
                    curList.add(curNode.val);
                } else {
                    curList.add(0, curNode.val);
                }
                // 处理每一个元素都一样，都要考虑一下左右子树
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            // 改换方向
            direction = !direction;
            res.add(curList);
        }
        return res;
    }

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

        Solution solution = new Solution();
        List<List<Integer>> zigzagLevelOrder = solution.zigzagLevelOrder(node1);
        zigzagLevelOrder.forEach(System.out::println);
    }
}