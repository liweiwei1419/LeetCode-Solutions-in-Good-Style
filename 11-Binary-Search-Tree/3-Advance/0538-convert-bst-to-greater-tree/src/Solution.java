import java.util.Stack;


public class Solution {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int cumSum = 0;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.right;
            }
            TreeNode pop = stack.pop();
            int curVal = pop.val;
            pop.val += cumSum;
            cumSum += curVal;
            p = pop.left;
        }
        return root;
    }


    /**
     * 使用中序遍历打印输出 BST
     *
     * @param node
     */
    private void printBST(TreeNode node) {
        if (node == null) {
            return;
        }
        printBST(node.left);
        System.out.println(node.val);
        printBST(node.right);
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node13 = new TreeNode(13);
        node5.left = node2;
        node5.right = node13;

        Solution solution = new Solution();
        solution.convertBST(node5);
        System.out.println("中序遍历 BST：");
        solution.printBST(node5);
    }
}