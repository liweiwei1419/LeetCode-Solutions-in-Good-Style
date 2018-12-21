# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    # 后序遍历
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
