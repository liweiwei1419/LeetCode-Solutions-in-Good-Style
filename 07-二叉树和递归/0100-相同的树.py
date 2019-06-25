# Definition for a binary tree node.
# 判断两棵二叉树是否一样。
# 典型的使用递归解决的问题。


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    # 递归

    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """

        if p is None and q is None:
            return True

        if p is None:
            return False

        if q is None:
            return False

        return p.val == q.val and self.isSameTree(
            p.left, q.left) and self.isSameTree(p.right, q.right)
