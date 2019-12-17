class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 方法1：用左子树中最大结点的代替自己

    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if root is None:
            return None

        if key < root.val:
            root.left = self.deleteNode(root.left, key)
            return root

        if key > root.val:
            root.right = self.deleteNode(root.right, key)
            return root

        if root.left is None:
            new_root = root.right
            root.right = None
            return new_root

        if root.right is None:
            new_root = root.left
            root.left = None
            return new_root

        # 找到左子树中最大的
        predecessor = self.__maximum(root.left)
        predecessor_copy = TreeNode(predecessor.val)
        predecessor_copy.left = self.__remove_max(root.left)
        predecessor_copy.right = root.right
        root.left = None
        root.right = None
        return predecessor_copy

    def __remove_max(self, node):
        if node.right is None:
            new_root = node.left
            node.left = None
            return new_root
        node.right = self.__remove_max(node.right)
        return node

    def __maximum(self, node):
        while node.right:
            node = node.right
        return node
