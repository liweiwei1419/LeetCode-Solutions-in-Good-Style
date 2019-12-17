class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 使用中序遍历得到 BST 第 k 小的那个元素

    def __init__(self):
        self.k = None
        self.res = None

    def __dfs(self, node):
        if node is None:
            return
        self.__dfs(node.left)
        self.k -= 1
        if self.k == 0:
            self.res = node.val
            return

        self.__dfs(node.right)

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.k = k
        self.__dfs(root)
        return self.res
