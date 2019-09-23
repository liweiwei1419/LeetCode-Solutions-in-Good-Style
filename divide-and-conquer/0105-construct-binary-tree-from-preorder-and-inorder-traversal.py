from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        pre_len = len(preorder)
        in_len = len(inorder)
        if pre_len != in_len:
            raise Exception('数据输入错误')
        root = self.__build_tree(preorder, 0, pre_len - 1, inorder, 0, in_len - 1)
        return root

    def __build_tree(self, preorder, pre_left, pre_right,
                     inorder, in_left, in_right):
        if pre_left > pre_right or in_left > in_right:
            return None

        pivot = preorder[pre_left]
        pivot_index = in_left
        while inorder[pivot_index] != pivot:
            pivot_index += 1
        root = TreeNode(pivot)
        root.left = self.__build_tree(preorder, pre_left + 1, pre_left + pivot_index - in_left,
                                      inorder, in_left, pivot_index - 1)

        root.right = self.__build_tree(preorder, pre_left + pivot_index - in_left + 1, pre_right,
                                       inorder, pivot_index + 1, in_right)
        return root
