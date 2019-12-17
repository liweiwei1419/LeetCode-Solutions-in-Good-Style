import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private enum Action {
        GO, ADDTORESULT
    }

    private class Command {
        private Action action;
        private TreeNode node;

        public Command(Action action, TreeNode node) {
            this.action = action;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Command> stack = new Stack<>();
        stack.add(new Command(Action.GO, root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.action == Action.ADDTORESULT) {
                res.add(command.node.val);
            } else {
                assert command.action == Action.GO;
                // 特别注意：以下的顺序是与递归执行的顺序反着来的，即：倒过来写的结果。
                stack.add(new Command(Action.ADDTORESULT, command.node));
                if (command.node.right != null) {
                    stack.add(new Command(Action.GO, command.node.right));
                }
                if (command.node.left != null) {
                    stack.add(new Command(Action.GO, command.node.left));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Solution solution = new Solution();
        List<Integer> preorderTraversal = solution.postorderTraversal(node1);
        System.out.println(preorderTraversal);
    }
}
