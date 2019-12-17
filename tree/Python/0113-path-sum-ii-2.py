from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        res = []
        if root is None:
            return res
        self.__helper(root, [], sum, res)
        return res

    def __helper(self, node, path, sum, res):
        if node is None:
            return
        path.append(node.val)
        if node.left is None and node.right is None and node.val == sum:
            res.append(path[:])
        if node.left:
            self.__helper(node.left, path, sum - node.val, res)
        if node.right:
            self.__helper(node.right, path, sum - node.val, res)
        path.pop()


if __name__ == '__main__':
    l = [1, 2, 3, 5]
    l2 = l.copy()
    l2[1] = 100
    print(l)
