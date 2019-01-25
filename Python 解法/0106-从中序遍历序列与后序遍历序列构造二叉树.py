# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """

        assert len(inorder) == len(postorder)

        if len(inorder) == 0:
            return None
        if len(inorder) == 1:
            # 这里要返回结点，而不是返回具体的数
            return TreeNode(inorder[0])

        root = TreeNode(postorder[-1])

        pos = inorder.index(postorder[-1])

        root.left = self.buildTree(inorder[:pos], postorder[:pos])
        root.right = self.buildTree(inorder[pos + 1:], postorder[pos:-1])
        return root


# 用于验证的方法
def validate(node):
    if node is None:
        return
    validate(node.left)
    print(node.val, end=' ')
    validate(node.right)


if __name__ == '__main__':
    inorder = [9, 3, 15, 20, 7]
    postorder = [9, 15, 7, 20, 3]
    solution = Solution()
    root = solution.buildTree(inorder, postorder)
    validate(root)
