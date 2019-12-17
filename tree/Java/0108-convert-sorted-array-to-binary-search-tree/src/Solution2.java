public class Solution2 {

    private TreeNode merge(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = merge(nums, left, mid);
        treeNode.right = merge(nums, mid + 1, right);
        return treeNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        return merge(nums, 0, len);
    }
}
