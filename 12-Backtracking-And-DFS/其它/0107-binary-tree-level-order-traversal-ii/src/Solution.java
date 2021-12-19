import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                current.add(top.val);

                if (top.left != null){
                    queue.add(top.left);
                }
                if (top.right != null){
                    queue.add(top.right);
                }
            }
            res.add(current);
        }

        Collections.reverse(res);
        return res;
    }
}