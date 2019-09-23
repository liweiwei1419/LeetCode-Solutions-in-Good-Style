class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def rob(self, root: TreeNode) -> int:
        if root is None:
            return 0

        # 分当前这一层偷不偷
        res = root.val
        if root.left:
            res += (self.rob(root.left.left) + self.rob(root.left.right))
        if root.right:
            res += (self.rob(root.right.left) + self.rob(root.right.right))
        return max(res, self.rob(root.left) + self.rob(root.right))
