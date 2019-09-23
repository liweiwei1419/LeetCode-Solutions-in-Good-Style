class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        depth = 0
        stack = [(1, root)]
        while stack:
            cur_depth, node = stack.pop()
            depth = max(depth, cur_depth)
            if node.right:
                stack.append((cur_depth + 1, node.right))
            if node.left:
                stack.append((cur_depth + 1, node.left))
        return depth
