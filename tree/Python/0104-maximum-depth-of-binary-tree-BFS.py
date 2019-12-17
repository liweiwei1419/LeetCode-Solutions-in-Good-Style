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
        queue = [root]
        while queue:
            size = len(queue)
            depth += 1
            for _ in range(size):
                first = queue.pop(0)
                if first.left:
                    queue.append(first.left)
                if first.right:
                    queue.append(first.right)
        return depth
