import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    /**
     * 哈希表的方式，其实前中后序都能通过，甚至层序遍历也行
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        // 因为 BST 中所有的数字都是不相同的，所以可以使用 Set
        Set<Integer> set = new HashSet<>();
        boolean[] res = new boolean[1];
        preOrder(root, set, k, res);
        return res[0];
    }

    private void preOrder(TreeNode node, Set<Integer> set, int k, boolean[] res) {
        if (node == null) {
            return;
        }
        // 2 * node.val == k 的情况，因为 BST 中，所有的数都不相同（即 k 的一半这个数一定不是我们要找的 ）
        if (set.contains(k - node.val) && 2 * node.val != k) {
            res[0] = true;
            return;
        } else {
            set.add(node.val);
        }
        preOrder(node.left, set, k, res);
        preOrder(node.right, set, k, res);
    }
}