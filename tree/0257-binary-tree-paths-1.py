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
        path = []
        self.__helper(root, path, res)
        return res

    def __helper(self, node, path, res):
        """
        :param node:
        :param path: 沿途经过的结点值组成的列表
        :param res: 存放最终结果的变量
        :return:
        """
        if node is None:
            return
        path.append(str(node.val))
        if node.left is None and node.right is None:
            # 可以结算了
            res.append("->".join(path))
            return
        if node.left:
            self.__helper(node.left, path, res)
            # 【重点】：回溯的时候，要记得弹出
            # 左边结点都看过了，所以 path 要弹出
            path.pop()
        if node.right:
            self.__helper(node.right, path, res)
            # 【重点】：回溯的时候，要记得弹出
            # 右边结点都看过了，所以 path 要弹出
            path.pop()


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


