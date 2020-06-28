import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    // 层序遍历

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode top = queue.poll();

            TreeNode temp =  top.left;
            top.left =  top.right;
            top.right = temp;

            if (top.left != null) {
                queue.offer(top.left);
            }
            if (top.right != null) {
                queue.offer(top.right);
            }
        }

        return root;
    }
}