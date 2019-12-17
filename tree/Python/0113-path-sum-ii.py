from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res = []
        self.__dfs([], root, sum, res)
        return res

    def __dfs(self, path, root, sum, results):
        if root is None:
            return
        if root.left is None and root.right is None and root.val == sum:
            result = []
            result.extend(path)
            result.append(root.val)
            results.append(result)
            return
        path.append(root.val)
        if root.left:
            self.__dfs(path, root.left, sum - root.val, results)
        if root.right:
            self.__dfs(path, root.right, sum - root.val, results)
        # 这一步很关键
        path.pop()
