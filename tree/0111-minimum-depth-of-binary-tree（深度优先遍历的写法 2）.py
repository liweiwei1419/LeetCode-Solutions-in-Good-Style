class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def __init__(self):
        self.min_depth = float("inf")

    def minDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        self.__dfs(root, 0)
        return self.min_depth

    def __dfs(self, node, depth):
        if node is None:
            return
        depth += 1
        if node.left is None and node.right is None:
            self.min_depth = min(self.min_depth, depth)
            return
        if node.left:
            self.__dfs(node.left, depth)
        if node.right:
            self.__dfs(node.right, depth)
