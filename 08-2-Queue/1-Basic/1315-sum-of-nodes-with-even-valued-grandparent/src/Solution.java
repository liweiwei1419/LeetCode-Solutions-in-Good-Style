import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    // 层序遍历

    // 如果是偶数，给它的孩子结点一个标记
    // 收到标记的，孩子节点入队的时候，加上孩子节点的值

    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            boolean flag = false;
            if ((top.val & 1) == 0) {
                // 表示它的孩子节点开始收集工作
                flag = true;
            }

            if (top.left != null) {
                if (top.val < 0) {
                    res += top.left.val;
                }
                if (flag) {
                    top.left.val *= -1;
                }
                queue.add(top.left);
            }

            if (top.right != null) {
                if (top.val < 0) {
                    res += top.right.val;
                }

                if (flag) {
                    top.right.val *= -1;
                }
                queue.add(top.right);
            }
        }
        return res;
    }
}