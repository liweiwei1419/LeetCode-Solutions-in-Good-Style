from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 教科书上的前序遍历非递归写法

    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        res = []
        stack = [(1, root)]
        while stack:
            command, node = stack.pop()
            if command == 0:
                res.append(node.val)
            else:
                if node.right:
                    stack.append((1, node.right))
                if node.left:
                    stack.append((1, node.left))
                stack.append((0, node))
        return res
