# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# 112. 路径总和
# 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
#
# 说明: 叶子节点是指没有子节点的节点。


class Solution:
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
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
