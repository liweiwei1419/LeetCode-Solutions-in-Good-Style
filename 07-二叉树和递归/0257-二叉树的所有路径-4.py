# 257. 二叉树的所有路径
# 给定一个二叉树，返回所有从根节点到叶子节点的路径。
# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        res = []

        if root is None:
            return []

        if root.left is None and root.right is None:
            res.append(str(root.val))
            return res

        left_paths = self.binaryTreePaths(root.left)
        for lpath in left_paths:
            res.append(str(root.val) + '->' + lpath)

        right_paths = self.binaryTreePaths(root.right)
        for rpath in right_paths:
            res.append(str(root.val) + '->' + rpath)

        return res


if __name__ == '__main__':
    node1 = TreeNode(1)
    node2 = TreeNode(2)
    node3 = TreeNode(3)
    node5 = TreeNode(5)

    node1.left = node2
    node1.right = node3
    node2.right = node5

    solution = Solution()
    result = solution.binaryTreePaths(node1)
    print(result)
