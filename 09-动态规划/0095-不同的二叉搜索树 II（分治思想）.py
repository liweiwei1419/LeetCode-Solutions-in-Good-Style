# 95. 不同的二叉搜索树 II
# 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
#
# 示例:
#
# 输入: 3
# 输出:
# [
#   [1,null,3,2],
#   [3,2,null,1],
#   [3,1,null,null,2],
#   [2,1,3],
#   [1,null,2,null,3]
# ]
# 解释:
# 以上的输出对应以下 5 种不同结构的二叉搜索树：
#
#    1         3     3      2      1
#     \       /     /      / \      \
#      3     2     1      1   3      2
#     /     /       \                 \
#    2     1         2                 3

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """

        res = []
        if n <= 0:
            return res
        return self.helper(1, n)

    def helper(self, left, right):
        res = []
        if left > right:
            # 说明不构成区间，应该返回空结点
            res.append(None)
            return res
        elif left == right:
            res.append(TreeNode(left))
            return res
        else:
            for i in range(left, right + 1):
                left_sub_tree = self.helper(left, i - 1)
                right_sub_tree = self.helper(i + 1, right)
                for l in left_sub_tree:
                    for r in right_sub_tree:
                        root = TreeNode(i)
                        root.left = l
                        root.right = r
                        res.append(root)
        return res
