class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def flipEquiv(self, root1, root2):

        if root1 is None and root2 is None:
            return True

        if root1 is None or root2 is None or root1.val != root2.val:
            return False

        if root1 and root2 and root1.val == root2.val:
            left_equals_left = self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right)
            left_equals_right = self.flipEquiv(root1.left, root2.right) and self.flipEquiv(root1.right, root2.left)

            return left_equals_left or left_equals_right
