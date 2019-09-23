from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:

        if not root:
            return []
        stack = [(1, root)]
        res = []
        while stack:
            command, node = stack.pop()
            if command == 0:
                res.append(node.val)
            else:
                # 后序遍历：先左右子树，再自己
                # 入栈顺序：自己、右子树、左子树
                stack.append((0, node))
                if node.right:
                    stack.append((1, node.right))
                if node.left:
                    stack.append((1, node.left))
        return res
