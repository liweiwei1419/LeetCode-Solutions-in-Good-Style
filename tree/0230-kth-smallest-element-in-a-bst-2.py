class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        global counter, res
        counter = 0
        res = 0

        def dfs(root, k):
            if not root:
                # 如果是空，直接退出
                return
            dfs(root.left, k)
            global counter, res
            counter += 1
            if counter == k:
                res = root.val
            dfs(root.right, k)

        dfs(root, k)
        return res
