import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution4 {

    // BFS

    public List<Integer> rightSideView(TreeNode root) {
        // 创建一维数组接收结果值
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        // 创建队列进行层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            // 这里先不给 node 赋值
            TreeNode node = null;
            for (int i = 0; i < len; i++) {
                // 在这里赋值，每次取出的都是当前层最后一个元素
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(node.val);
        }
        return ans;
    }
}