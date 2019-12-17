from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        res = []
        if root is None:
            return res
        self.__helper(root, [str(root.val)], res)
        return res

    def __helper(self, node, pre, res):
        # 隐式回溯
        # pre 表示一组解
        if node is None:
            return
        if node.left is None and node.right is None:
            res.append('->'.join(pre))
        # 通过参数传递的方式，就没有显式的回溯和状态重置的过程了
        if node.left:
            self.__helper(node.left, pre + [str(node.left.val)], res)
        if node.right:
            self.__helper(node.right, pre + [str(node.right.val)], res)


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
