public class Solution4 {

    private int[] inorder;
    private int[] postorder;


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        int len = inorder.length;
        return dfs(0, len - 1, 0, len - 1);
    }


    private TreeNode dfs(int inl, int inr, int postl, int postr) {
        if (inl > inr || postl > postr) {
            return null;
        }

        int val = postorder[postr];
        int k = 0;
        for (int i = inl; i < inr + 1; i++) {
            if (inorder[i] == val) {
                k = i;
                break;
            }
        }

        TreeNode root = new TreeNode(val);
        // 注意：第 4 个参数是计算出来的，依据：两边区间长度相等
        root.left = dfs(inl, k - 1, postl, k - 1 - inl + postl);
        // 注意：第 3 个参数是计算出来的，依据：两边区间长度相等
        root.right = dfs(k + 1, inr, postr + k - inr, postr - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {1, 3, 2};
        int[] postorder = {3, 2, 1};

        Solution solution = new Solution();

        TreeNode res = solution.buildTree(inorder, postorder);
        System.out.println(res);
    }
}
