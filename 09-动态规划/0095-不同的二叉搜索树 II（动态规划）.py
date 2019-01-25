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
        if n <= 0:
            return []
        res = [None] * (n + 1)
        res[0] = [None]
        for i in range(1, n + 1):
            # 初始化一个列表对象
            res[i] = []
            for j in range(i):
                for left in res[j]:
                    for right in res[i - j - 1]:
                        # 注意：这里是 j + 1 ，表示根结点，画个图就很清楚了
                        root = TreeNode(j + 1)
                        root.left = left
                        # 每个结点都有固定偏移的拷贝
                        root.right = self.__shift_clone(right, j + 1)
                        res[i].append(root)
        return res[n]

    def __shift_clone(self, root, k):
        if root is None:
            return root
        cur_node = TreeNode(root.val + k)
        cur_node.left = self.__shift_clone(root.left, k)
        cur_node.right = self.__shift_clone(root.right, k)
        return cur_node
