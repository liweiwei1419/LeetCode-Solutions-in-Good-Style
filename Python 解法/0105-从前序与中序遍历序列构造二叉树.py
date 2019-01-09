# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    # https://www.bilibili.com/video/av7420546?from=search&seid=6242384381313003008
    # 前序遍历的第 1 个点肯定是根结点
    # 参考资料：https://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal/

    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        plen = len(preorder)
        ilen = len(inorder)
        return self.__helper(preorder, 0, plen - 1, inorder, 0, ilen - 1)

    def __helper(self, preorder, prel, prer,
                 inorder, inl, inr):
        if prel > prer:
            return None
        root_val = preorder[prel]
        l = inl
        while l < inr and inorder[l] != root_val:
            l += 1
        # 走到这里 inorder[l] == root 为 True
        root_node = TreeNode(root_val)
        root_node.left = self.__helper(preorder, prel + 1, prel + l - inl,
                                       inorder, inl, l - 1)
        root_node.right = self.__helper(preorder, prel + l - inl + 1, prer,
                                        inorder, l + 1, inr)
        return root_node
