import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution4 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root, sum, path, res);
        return res;
    }


    // 如果使用链表的话，一定要使用 addLast 和 removeLast
    // 如果使用 push 和 poll 相应的会在链表的头部操作，就不是我们的本意了

    public void pathSum(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        if (node.val == sum && node.left == null && node.right == null) {
            path.addLast(node.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.addLast(node.val);
        pathSum(node.left, sum - node.val, path, res);

        pathSum(node.right, sum - node.val, path, res);
        path.removeLast();
    }
}