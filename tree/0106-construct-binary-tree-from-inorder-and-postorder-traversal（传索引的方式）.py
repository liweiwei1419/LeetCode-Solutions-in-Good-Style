from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def __init__(self):
        self.inorder = None
        self.postorder = None

    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        assert len(inorder) == len(postorder)
        size = len(inorder)

        self.inorder = inorder
        self.postorder = postorder
        return self.__dfs(0, size - 1, 0, size - 1)

    def __dfs(self, in_l, in_r, post_l, post_r):
        if in_l > in_r or post_l > post_r:
            return None

        val = self.postorder[post_r]
        # 后序遍历的最后一个结点就是根结点
        root = TreeNode(val)
        # 在中序遍历中找到根结点的索引，得到左右子树的一个划分
        pos = self.inorder.index(val)

        # 注意：第 4 个参数是计算出来的，依据：两边区间长度相等
        root.left = self.__dfs(in_l, pos - 1, post_l, pos - 1 - in_l + post_l)
        # 注意：第 3 个参数是计算出来的，依据：两边区间长度相等
        root.right = self.__dfs(pos + 1, in_r, post_r - in_r + pos, post_r - 1)
        return root


# 用于验证的方法
def validate(node):
    if node is None:
        return
    validate(node.left)
    print(node.val, end=' ')
    validate(node.right)


if __name__ == '__main__':
    inorder = [1, 3, 2]
    postorder = [3, 2, 1]
    solution = Solution()
    root = solution.buildTree(inorder, postorder)
    validate(root)

    from fractions import Fraction

    value = 4.2
    print(Fraction(value).limit_denominator())
