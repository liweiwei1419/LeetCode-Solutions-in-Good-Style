# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 404. 左叶子之和
# 计算给定二叉树的所有左叶子之和。

# 非递归写法：参考：LeetCode 404. Sum of Left Leaves 解题报告
# https://blog.csdn.net/camellhf/article/details/52682113

class Solution:

    # 关键在于判断是否是左边叶子结点
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0

        queue = [root]
        res = 0
        while queue:

            top = queue.pop(0)
            if top.left and top.left.left is None is top.left.right is None:
                res += top.left.val
            if top.left:
                queue.append(top.left)
            if top.right:
                queue.append(top.right)
        return res
