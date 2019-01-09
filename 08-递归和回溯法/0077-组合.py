# 77. 组合
# 题目描述提示帮助提交记录社区讨论阅读解答
# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
class Solution:
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """

        # 先把不符合条件的情况去掉
