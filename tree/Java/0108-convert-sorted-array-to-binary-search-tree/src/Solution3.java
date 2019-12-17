public class Solution3 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        int l = 0;
        int r = len - 1;
        return sortedArrayToBST(nums, l, r);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        // 递归终止的条件要先写
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}
