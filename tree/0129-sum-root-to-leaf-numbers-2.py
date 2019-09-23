class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        res = []
        self.__dfs(root, 0, res)
        return sum(res)

    # Python 中对于基础的数据类型是值传递，即复制
    def __dfs(self, root, cum_sum, res):
        if root is None:
            return None
        if root.left is None and root.right is None:
            # 结算
            res.append(cum_sum * 10 + root.val)
            return
        self.__dfs(root.left, cum_sum * 10 + root.val, res)
        self.__dfs(root.right, cum_sum * 10 + root.val, res)
