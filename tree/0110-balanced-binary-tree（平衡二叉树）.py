class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 关心递归函数的语义

    def isBalanced(self, root: TreeNode) -> bool:
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
