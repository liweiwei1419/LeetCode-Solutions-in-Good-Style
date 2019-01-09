# 129. 求根到叶子节点数字之和
# 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
# 例如，从根到叶子节点路径 1->2->3 代表数字 123。
# 计算从根到叶子节点生成的所有数字之和。
# 说明: 叶子节点是指没有子节点的节点。

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def __init__(self):
        self.res = 0

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        if root.left:
            # 如果左边非空
            root.left.val += root.val * 10
        if root.right:
            # 如果右边非空
            root.right.val += root.val * 10
        # 如果左边右边都为空，就可以结算了
        if root.left is None and root.right is None:
            self.res += root.val
        # 前序遍历
        self.sumNumbers(root.left)
        self.sumNumbers(root.right)
        return self.res
