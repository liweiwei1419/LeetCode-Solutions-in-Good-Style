import java.util.ArrayList;
import java.util.List;


public class Solution2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 从根结点到叶子结点的路径
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null) {
            if (sum == 0) {
                // 正是因为每一次向下传递的过程中复制整个列表，在叶子结点出直接添加即可
                res.add(path);
                return;
            }
        }

        // 基本数据类型在方法传递过程中的行为是是复制
        // new ArrayList<>() 每一次向下传递的过程中复制整个列表，低效
        dfs(root.left, sum, new ArrayList<>(path), res);
        dfs(root.right, sum, new ArrayList<>(path), res);
    }
}