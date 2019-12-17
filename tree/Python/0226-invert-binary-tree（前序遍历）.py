class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 前序遍历

    def invertTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return

        # 交换左右子树
        root.left, root.right = root.right, root.left

        self.invertTree(root.left)
        self.invertTree(root.right)
        return root
