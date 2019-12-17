import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getSum(root, new ArrayList<Integer>(), 0, sum);
        return res;
    }

    private void getSum(TreeNode node, ArrayList<Integer> list, int current, int sum) {
        if (node == null) {
            return;
        }
        current += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (current == sum) {
                res.add(list);
            } else {
                // 什么都不做
                return;
            }
        }
        if (node.left != null) {
            getSum(node.left, new ArrayList<>(), current, sum);
        }
        if (node.right != null) {
            getSum(node.right, new ArrayList<>(), current, sum);
        }
    }
}
