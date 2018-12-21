# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        if root is None:
            return 0

        l_sub_tree_depth = self.maxDepth(root.left)
        r_sub_tree_depth = self.maxDepth(root.right)

        return max(l_sub_tree_depth, r_sub_tree_depth) + 1
