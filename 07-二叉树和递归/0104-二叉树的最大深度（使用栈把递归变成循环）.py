# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 求一棵二叉树的最大深度。
# 要能看出这道题本质上是二叉树的后序遍历。


class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        depth = 0
        stack = [(1, root)]
        while stack:
            cur_depth, node = stack.pop()
            depth = max(depth, cur_depth)
            if node.left:
                stack.append((cur_depth + 1, node.left))
            if node.right:
                stack.append((cur_depth + 1, node.right))
        return depth
