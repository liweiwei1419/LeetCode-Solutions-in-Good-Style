# Definition for a binary tree node.
# 111. 二叉树的最小深度
# 给定一个二叉树，找出其最小深度。
#
# 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
#
# 说明: 叶子节点是指没有子节点的节点。


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        if root is None:
            return 0
        depth = 0
        queue = [root]
        while queue:
            depth += 1
            size = len(queue)
            for _ in range(size):
                first = queue.pop(0)
                if first.left is None and first.right is None:
                    return depth
                if first.left:
                    queue.append(first.left)
                if first.right:
                    queue.append(first.right)
