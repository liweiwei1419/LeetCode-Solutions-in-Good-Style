# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):

    # 递归解法

    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        res = []
        self.__helper(root, res)
        return res

    def __helper(self, node, res):
        if node is None:
            return

        self.__helper(node.left, res)
        res.append(node.val)
        self.__helper(node.right, res)
