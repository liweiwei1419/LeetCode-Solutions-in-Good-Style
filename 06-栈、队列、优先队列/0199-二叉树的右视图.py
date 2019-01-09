# 199. 二叉树的右视图
# 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        def dfs(node, res, depth):
            if node is None:
                return
            if len(res) == depth:
                res.append(node.val)
            dfs(node.right, res, depth + 1)
            dfs(node.left, res, depth + 1)

        res = []
        dfs(root, res, 0)
        return res
