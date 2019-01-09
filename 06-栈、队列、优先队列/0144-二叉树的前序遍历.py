# 144. 二叉树的前序遍历
# 掌握前序遍历，使用栈的写法

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 教科书上的前序遍历非递归写法

class Solution:
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []

        stack = [root]
        res = []
        while stack:
            node = stack.pop()
            # 前序遍历：先自己，再左孩子，右孩子
            res.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return res
