class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 解题关键：中序遍历
// 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
// 只要利用二分搜索树的中序遍历，就可以完成

public class Solution {
    private int count = 0;
    private int res = 0;

    private void dfs(TreeNode node) {
        // 先写递归终止条件
        if (node == null) {
            // 什么都不做
            return;
        }

        dfs(node.left);

        count--;
        if (count == 0) {
            this.res = node.val;
            // 这里的 return 可加可不加
            return;
        }

        dfs(node.right);
    }

    // k 如果在方法传递的过程中是值传递，所以把它设置为成员变量，这样就是引用传递
    // 因为我们要用到 k 全局的值，去数出，我是第几个中序遍历到的值

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(20);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        Solution solution = new Solution();
        int kthSmallest = solution.kthSmallest(treeNode2, 2);
        System.out.println(kthSmallest);
    }
}





