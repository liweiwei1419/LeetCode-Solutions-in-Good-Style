class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        # 介于二者之间
        if p.val <= root.val <= q.val or q.val <= root.val <= p.val:
            return root
        if root.val < p.val and root.val < q.val:
            # 比二者都小
            return self.lowestCommonAncestor(root.right, p, q)
        if root.val > p.val and root.val > q.val:
            # 比二者都大
            return self.lowestCommonAncestor(root.left, p, q)
