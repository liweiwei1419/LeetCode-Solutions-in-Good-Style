class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 方法2：用右子树中最小结点的代替自己


class Solution:
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

        # 找到右子树中最小的结点，复制它的值
        successor = self.__minimum(root.right)
        successor_copy = TreeNode(successor.val)
        successor_copy.left = root.left
        successor_copy.right = self.__remove_min(root.right)
        root.left = None
        root.right = None
        return successor_copy

    def __remove_min(self, node):
        if node.left is None:
            new_root = node.right
            node.right = None
            return new_root
        node.left = self.__remove_min(node.left)
        return node

    def __minimum(self, node):
        while node.left:
            node = node.left
        return node
