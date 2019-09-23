from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# 递归求解

class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        res = []
        # 前面先讨论递归到底的情况情况
        if root is None:
            return res

        if root.left is None and root.right is None:
            res.append(str(root.val))
            return res

        # 字符串列表
        left_paths = self.binaryTreePaths(root.left)
        for path in left_paths:
            res.append(str(root.val) + '->' + path)
        # 字符串列表
        right_paths = self.binaryTreePaths(root.right)
        for path in right_paths:
            res.append(str(root.val) + '->' + path)

        return res
