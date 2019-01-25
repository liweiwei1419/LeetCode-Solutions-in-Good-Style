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
        queue = [root]
        while queue:
            size = len(queue)
            depth += 1
            for _ in range(size):
                first = queue.pop(0)
                if first.left:
                    queue.append(first.left)
                if first.right:
                    queue.append(first.right)
        return depth
