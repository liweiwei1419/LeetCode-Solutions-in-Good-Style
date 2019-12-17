import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Solution3 {

    // 使用层序遍历的思想

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (i == 0) {
                    res.add(node.val);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
            }
        }
        return res;
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

        Solution3 solution3 = new Solution3();
        List<Integer> rightSideView = solution3.rightSideView(treeNode1);
        System.out.println(rightSideView);
    }
}
