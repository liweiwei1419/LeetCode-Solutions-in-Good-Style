class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def countNodes(self, root: TreeNode) -> int:
        left_depth = self.__depth(root, True)
        right_depth = self.__depth(root, False)

        if left_depth == right_depth:
            # return 2 ** left_depth - 1
            return (1 << left_depth) - 1
        if left_depth > right_depth:
            return 1 + self.countNodes(root.left) + self.countNodes(root.right)

    def __depth(self, node, is_left):
        depth = 0
        while node:
            depth += 1
            node = node.left if is_left else node.right
        return depth
