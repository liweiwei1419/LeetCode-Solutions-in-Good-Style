class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def __init__(self):
        self.parent = None

    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        if root is None:
            return

        self.flatten(root.right)
        self.flatten(root.left)

        root.right = self.parent
        root.left = None

        self.parent = root
