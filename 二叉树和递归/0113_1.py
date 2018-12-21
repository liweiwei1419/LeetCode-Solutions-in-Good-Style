# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 使用 dfs 来解决

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """

        results = []
        self.__dfs([], root, sum, results)
        return results

    def __dfs(self, path, root, sum, results):
        if root is None:
            return
        if root.left is None and root.right is None and root.val == sum:
            result = []
            result.extend(path)
            result.append(root.val)
            results.append(result)
            return
        path.append(root.val)
        if root.left:
            self.__dfs(path, root.left, sum - root.val, results)
        if root.right:
            self.__dfs(path, root.right, sum - root.val, results)
        # 这一步很关键
        path.pop()
