# 437. 路径总和 III
# 给定一个二叉树，它的每个结点都存放着一个整数值。
#
# 找出路径和等于给定数值的路径总数。
#
# 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
#
# 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 这个解答来自评论区，暂时没有看懂

class Solution:
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        from collections import defaultdict
        memo = defaultdict(int)
        # 记忆化递归，memo 表示缓存
        memo[0] = 1  # 表示 cur - sum = 0, return 1
        self.res = 0

        def helper(root, curSum):
            if root is None:
                return
            curSum += root.val
            self.res += memo[curSum - sum]
            memo[curSum] += 1

            helper(root.left, curSum)
            helper(root.right, curSum)
            memo[curSum] -= 1

        helper(root, 0)
        return self.res
