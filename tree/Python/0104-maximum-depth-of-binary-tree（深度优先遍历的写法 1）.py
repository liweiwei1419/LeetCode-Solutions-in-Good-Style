class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    # 求一棵二叉树的最大深度，本质上是二叉树的后序遍历

    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        # 先计算左右子树，然后再计算自己，这是后序遍历
        l_sub_tree_depth = self.maxDepth(root.left)
        r_sub_tree_depth = self.maxDepth(root.right)
        return max(l_sub_tree_depth, r_sub_tree_depth) + 1
