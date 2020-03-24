import java.util.Stack;

public class Solution4 {

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

    public int kthSmallest(TreeNode root, int k) {
        Stack<Command> stack = new Stack<>();
        stack.add(new Command(Action.GO, root));
        while (!stack.isEmpty()) {
            Command cur = stack.pop();
            TreeNode node = cur.node;
            if (cur.action == Action.ADDTORESULT) {
                k--;
                if (k == 0) {
                    return node.val;
                }
            } else {
                assert cur.action == Action.GO;
                if (node.right != null) {
                    stack.add(new Command(Action.GO, node.right));
                }
                stack.add(new Command(Action.ADDTORESULT, node));
                if (node.left != null) {
                    stack.add(new Command(Action.GO, node.left));
                }
            }
        }
        throw new RuntimeException("参数错误");
    }

}





