import java.util.ArrayList;
import java.util.List;


public class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 根节点
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> temp1 = new ArrayList<>();
                temp1.add(root.val);
                result.add(temp1);
                return result;
            }
        }
        List<List<Integer>> leftLists = pathSum(root.left, sum - root.val);
        mergeOneAndList(root, leftLists, result);
        List<List<Integer>> rightLists = pathSum(root.right, sum - root.val);
        mergeOneAndList(root, rightLists, result);
        return result;
    }

    private void mergeOneAndList(TreeNode node, List<List<Integer>> listList, List<List<Integer>> result) {
        for (int i = 0; i < listList.size(); i++) {
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(node.val);
            temp1.addAll(listList.get(i));
            result.add(temp1);
        }
    }


    /**
     * 想一想有没有办法快速创建二叉树
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode4_ = new TreeNode(4);

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5_ = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode4_;
        treeNode4_.left = treeNode5_;
        treeNode4_.right = treeNode1;

        Solution2 solution2 = new Solution2();
        List<List<Integer>> listList = solution2.pathSum(treeNode5, 22);
        System.out.println(listList);


    }
}
