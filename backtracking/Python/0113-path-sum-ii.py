from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 用减法

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        def dfs(node, path, sum, res):
            if node is None:
                return

            if node.left is None and node.right is None and node.val == sum:
                res.append(path + [node.val])
                return

            path.append(node.val)

            if node.left:
                dfs(node.left, path, sum - node.val, res)
            if node.right:
                dfs(node.right, path, sum - node.val, res)
            path.pop()

        res = []
        dfs(root, [], sum, res)
        return res
