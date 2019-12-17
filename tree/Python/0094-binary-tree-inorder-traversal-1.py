from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 递归解法

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.__dfs(root, res)
        return res

    def __dfs(self, node, res):
        if node is None:
            return

        self.__dfs(node.left, res)
        res.append(node.val)
        self.__dfs(node.right, res)
