# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 235. 二叉搜索树的最近公共祖先
# 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。


class Solution:
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        # 介于二者之间
        if p.val <= root.val <= q.val or q.val <= root.val <= p.val:
            return root
        if root.val < p.val and root.val < q.val:
            # 比二者都小
            return self.lowestCommonAncestor(root.right, p, q)
        if root.val > p.val and root.val > q.val:
            # 比二者都大
            return self.lowestCommonAncestor(root.left, p, q)
