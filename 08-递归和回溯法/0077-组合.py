# 77. 组合
# 题目描述提示帮助提交记录社区讨论阅读解答
# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        # 先把不符合条件的情况去掉
        if n <= 0 or k <= 0 or k > n:
            return []
        res = []
        self.__dfs(1, k, n, [], res);
        return res

    def __dfs(self, start, k, n, pre, res):
        # 当前已经找到的组合存储在 pre 中，需要从 start 开始搜索新的元素

        if len(pre) == k:
            res.append(pre[:])
            return

        for i in range(start, n + 1):
            pre.append(i)
            # 因为已经把 i 加入到 pre 中，下一轮就从 i + 1 开始
            self.__dfs(i + 1, k, n, pre, res)
            # 回溯的时候，状态重置
            pre.pop()


if __name__ == '__main__':
    solution = Solution()
    n = 5
    k = 2
    res = solution.combine(n, k)
    print(res)
