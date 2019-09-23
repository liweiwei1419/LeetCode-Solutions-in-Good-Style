from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # “模拟系统栈”实现的二叉树“中序遍历”（推荐）

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stack = [(1, root)]
        while stack:
            command, node = stack.pop()
            if not node:
                continue
            if command == 0:
                res.append(node.val)
            if command == 1:
                # 左，自己，右，反过来就是
                # 右边，自己，左边
                stack.append((1, node.right))
                stack.append((0, node))
                stack.append((1, node.left))
        return res
