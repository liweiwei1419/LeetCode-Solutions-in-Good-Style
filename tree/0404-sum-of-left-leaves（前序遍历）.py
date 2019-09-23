class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 关键在于判断是否是左边叶子结点
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if root is None:
            return 0
        # 1、左边非空
        # 2、左边的左边是空
        # 3、左边的右边是空
        if root.left is not None and root.left.left is None and root.left.right is None:
            return root.left.val + self.sumOfLeftLeaves(root.right)
        return self.sumOfLeftLeaves(root.left) + self.sumOfLeftLeaves(root.right)
