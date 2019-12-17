class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private TreeNode merge(int[] nums, int left, int right) {
        if (left == right + 1) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = merge(nums, left, mid - 1);
        treeNode.right = merge(nums, mid + 1, right);
        return treeNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        return merge(nums, 0, len - 1);
    }
}
