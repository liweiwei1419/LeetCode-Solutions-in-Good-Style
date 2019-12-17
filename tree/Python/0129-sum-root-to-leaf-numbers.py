class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def __init__(self):
        self.res = 0

    def sumNumbers(self, root: TreeNode) -> int:

        if root is None:
            return 0
        if root.left:
            # 如果左边非空
            root.left.val += root.val * 10
        if root.right:
            # 如果右边非空
            root.right.val += root.val * 10
        # 如果左边右边都为空，就可以结算了
        if root.left is None and root.right is None:
            self.res += root.val
        # 前序遍历
        self.sumNumbers(root.left)
        self.sumNumbers(root.right)
        return self.res
