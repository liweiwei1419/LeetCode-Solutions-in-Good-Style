# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def kthSmallest(self, root, k):
        stack = [(1, root)]
        while stack:
            command, node = stack.pop()
            if command == 0:
                k -= 1
                if k == 0:
                    return node.val
            else:
                # 模拟系统栈实现中序遍历(先左边、再自己、再右边)
                if node.right:
                    stack.append((1, node.right))
                stack.append((0, node))
                if node.left:
                    stack.append((1, node.left))
