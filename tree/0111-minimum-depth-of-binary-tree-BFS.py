class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        depth = 0
        queue = [root]
        while queue:
            depth += 1
            size = len(queue)
            for _ in range(size):
                first = queue.pop(0)
                if first.left is None and first.right is None:
                    return depth
                if first.left:
                    queue.append(first.left)
                if first.right:
                    queue.append(first.right)
