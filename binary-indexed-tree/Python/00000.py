from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def __init__(self):
        self.preorder = None
        self.reverses = None

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        pre_size = len(preorder)
        in_size = len(inorder)
        if pre_size != in_size:
            return None

        self.preorder = preorder
        self.reverses = dict()
        for i in range(in_size):
            self.reverses[inorder[i]] = i

        return self.__build_tree(0, pre_size - 1, 0, in_size - 1)

    def __build_tree(self, pre_left, pre_right, in_left, in_right):
        if pre_left > pre_right or in_left > in_right:
            return None

        pivot = self.preorder[pre_left]
        root = TreeNode(pivot)

        pivot_index = self.reverses[pivot]
        root.left = self.__build_tree(pre_left + 1, pivot_index - in_left + pre_left, in_left, pivot_index - 1)
        root.right = self.__build_tree(pivot_index - in_left + pre_left + 1, pre_right, pivot_index + 1, in_right)
        return root


if __name__ == '__main__':
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    solution = Solution()

    res = solution.buildTree(preorder, inorder)
    print(res.val)
