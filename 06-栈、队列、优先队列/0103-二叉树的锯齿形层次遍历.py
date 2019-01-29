# 103. 二叉树的锯齿形层次遍历
# 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
#
# 例如：
# 给定二叉树 [3,9,20,null,null,15,7],
#
#     3
#    / \
#   9  20
#     /  \
#    15   7
# 返回锯齿形层次遍历如下：
#
# [
#   [3],
#   [20,9],
#   [15,7]
# ]

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []

        queue = [root]
        res = []
        turn_left = True
        while queue:
            cur_list = []
            size = len(queue)
            for _ in range(size):
                top = queue.pop(0)

                if turn_left:
                    cur_list.append(top.val)
                else:
                    cur_list.insert(0, top.val)

                if top.left:
                    queue.append(top.left)
                if top.right:
                    queue.append(top.right)
            res.append(cur_list)
            turn_left = not turn_left
        return res
