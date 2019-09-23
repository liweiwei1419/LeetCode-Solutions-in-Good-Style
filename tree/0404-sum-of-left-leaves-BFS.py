class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if root is None:
            return 0

        queue = [root]
        res = 0
        while queue:
            top = queue.pop(0)
            if top.left and top.left.left is None is top.left.right is None:
                res += top.left.val
            if top.left:
                queue.append(top.left)
            if top.right:
                queue.append(top.right)
        return res
