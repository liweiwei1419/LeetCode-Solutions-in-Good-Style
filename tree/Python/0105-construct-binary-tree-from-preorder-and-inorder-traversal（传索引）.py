from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        plen = len(preorder)
        ilen = len(inorder)
        return self.__helper(preorder, 0, plen - 1, inorder, 0, ilen - 1)

    def __helper(self, preorder, prel, prer,
                 inorder, inl, inr):
        if prel > prer:
            return None
        root_val = preorder[prel]
        index = inl
        while index < inr and inorder[index] != root_val:
            index += 1
        # 走到这里 inorder[index] == root 为 True
        root_node = TreeNode(root_val)
        root_node.left = self.__helper(preorder, prel + 1, prel + index - inl,
                                       inorder, inl, index - 1)
        root_node.right = self.__helper(preorder, prel + index - inl + 1, prer,
                                        inorder, index + 1, inr)
        return root_node
