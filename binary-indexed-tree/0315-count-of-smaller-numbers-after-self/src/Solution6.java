import java.util.ArrayList;
import java.util.List;

/**
 * BST
 */
public class Solution6 {

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
        // 左子树的结点总数
        private int leftNodeSum;
        private int duplicateTimes = 1;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int[] counter;

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        counter = new int[len];
        TreeNode root = null;
        for (int i = len - 1; i >= 0; i--) {
            root = insert(root, nums[i], i, 0);
        }
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }

    /**
     * @param node
     * @param val
     * @param index
     * @param cumLeftNodeSum 累积经过的比当前结点要小的数
     * @return 二分搜索树新的根
     */
    private TreeNode insert(TreeNode node, int val, int index, int cumLeftNodeSum) {
        if (node == null) {
            node = new TreeNode(val);
            counter[index] = cumLeftNodeSum;
            return node;
        }
        // 分类讨论：找到相同 val 的节点，插入左子树中，插入右子树中
        if (node.val == val) {
            node.duplicateTimes++;
            // 最后要返回的是这个数组
            counter[index] = cumLeftNodeSum + node.leftNodeSum;
        } else if (val < node.val) {
            // 当前左子树包含的结点数 + 1
            node.leftNodeSum++;
            node.left = insert(node.left, val, index, cumLeftNodeSum);
        } else {
            assert val > node.val;
            // 稍微有点复杂，要要小心
            node.right = insert(node.right, val, index, cumLeftNodeSum + node.duplicateTimes + node.leftNodeSum);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        Solution3 solution3 = new Solution3();
        List<Integer> countSmaller = solution3.countSmaller(nums);
        System.out.println(countSmaller);
    }
}
