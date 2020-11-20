import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.empty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            TreeNode p = top.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        return top.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node2.left = node1;
        node2.right = node5;
        node5.left = node4;
        node4.left = node3;

        BSTIterator bstIterator = new BSTIterator(node2);
        while (bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */