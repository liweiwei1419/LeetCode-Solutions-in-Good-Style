class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 中序遍历

    def invertTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return
        self.invertTree(root.left)

        # 交换左右子树
        root.left, root.right = root.right, root.left

        # 注意：这里的 root.left 就是交换之前的 root.right
        self.invertTree(root.left)
        return root
