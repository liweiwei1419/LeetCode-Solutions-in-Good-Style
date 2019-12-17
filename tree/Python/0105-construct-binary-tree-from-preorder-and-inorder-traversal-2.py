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
        # 不能构成区间，所以返回根结点
        if prel > prer or inl > inr:
            return None
        root_val = preorder[prel]
        index = inl
        step = 0
        while index < inr and inorder[index] != root_val:
            step += 1
            index += 1
        root_node = TreeNode(root_val)
        root_node.left = self.__helper(preorder, prel + 1, prel + step,
                                       inorder, inl, inl + step - 1)
        # 特别注意这个细节，中序遍历开始的时候，是 (inl + step - 1) 这个数值跳过一个结点
        root_node.right = self.__helper(preorder, prel + step + 1, prer,
                                        inorder, inl + step + 1, inr)
        return root_node
