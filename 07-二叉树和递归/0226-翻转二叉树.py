# Definition for a binary tree node.
# 226. 翻转二叉树
# 翻转一棵二叉树。


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    # 后序遍历，先翻转左右子树，再交换它们
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return
        self.invertTree(root.left)
        self.invertTree(root.right)
        # 交换左右子树
        root.left, root.right = root.right, root.left
        return root
