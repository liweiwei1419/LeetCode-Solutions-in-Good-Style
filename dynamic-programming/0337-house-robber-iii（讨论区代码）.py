class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def rob(self, root: TreeNode) -> int:
        if not root:
            return 0
        root_left = self.rob(root.left.left) + self.rob(root.left.right) if root.left else 0
        root_right = self.rob(root.right.left) + self.rob(root.right.right) if root.right else 0
        return max(root.val + root_left + root_right, self.rob(root.left) + self.rob(root.right))
