# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 给定一个二叉树，判断它是否是高度平衡的二叉树。
# 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。


class Solution:
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        # 先写特殊情况，空树是平衡二叉树
        if root is None:
            return True
        return self.__helper(root) != -1

    def __helper(self, node):
        # 因为必须从底下到上面依次判断，所以使用后序遍历
        if node is None:
            return 0
        left = self.__helper(node.left)
        right = self.__helper(node.right)
        if left == -1 or right == -1 or abs(left - right) > 1:
            return -1
        # 重点，辅助函数的定义是，左右子树的高度中最大的那个
        return max(left, right) + 1
