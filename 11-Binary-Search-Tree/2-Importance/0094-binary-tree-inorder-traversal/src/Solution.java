import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Solution {

    private enum Action {
        // GO 表示递归处理
        // ADDTORESULT 表示当前马上执行将结点的值添加到结果集中
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Command> stack = new ArrayDeque<>();
        stack.addLast(new Command(Action.GO, root));

        while (!stack.isEmpty()) {
            Command command = stack.removeLast();

            if (command.action == Action.ADDTORESULT) {
                res.add(command.node.val);
            } else {
                assert command.action == Action.GO;
                // 关键在这里：因为是模拟系统栈，应该把中序遍历的顺序倒过来写
                // 调整一下顺序就可以完成前序遍历和后序遍历

                if (command.node.right != null) {
                    stack.add(new Command(Action.GO, command.node.right));
                }

                stack.add(new Command(Action.ADDTORESULT, command.node));

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
        List<Integer> preorderTraversal = solution.inorderTraversal(node1);
        System.out.println(preorderTraversal);
    }
}