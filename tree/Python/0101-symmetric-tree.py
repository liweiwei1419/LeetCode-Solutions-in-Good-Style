class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 还可以使用队列去完成
    # https://leetcode.com/problems/symmetric-tree/solution/

    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        return self.__helper(root.left, root.right)

    def __helper(self, left_node, right_node):
        if left_node is None and right_node is None:
            return True
        if left_node is None or right_node is None or left_node.val != right_node.val:
            return False
        return self.__helper(left_node.left, right_node.right) and self.__helper(
            left_node.right, right_node.left)
