class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def __init__(self):
        self.max_depth = 0

    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        self.__dfs(root, 0)
        return self.max_depth

    def __dfs(self, node, depth):
        if node is None:
            return
        depth += 1
        if node.left is None and node.right is None:
            self.max_depth = max(self.max_depth, depth)
            return
        if node.left:
            self.__dfs(node.left, depth)
        if node.right:
            self.__dfs(node.right, depth)
