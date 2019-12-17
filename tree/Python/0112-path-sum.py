class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 注意递归函数的语义

    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if root is None:
            return False
        # 此时 root 不为空
        # 左边看一看，右边看一看
        # 【重点】一定要记得判断，左边子树和右边子树同时为空，说明走到底了
        if root.left is None and root.right is None and root.val == sum:
            return True
        left_has = self.hasPathSum(root.left, sum - root.val)
        right_has = self.hasPathSum(root.right, sum - root.val)
        return left_has or right_has
