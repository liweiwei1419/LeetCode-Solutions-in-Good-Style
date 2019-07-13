# 77. 组合
# 题目描述提示帮助提交记录社区讨论阅读解答
# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
from typing import List


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        # 特判
        if n <= 0 or k <= 0 or k > n:
            return []
        res = []
        self.__dfs(1, k, n, [], res)
        return res

    def __dfs(self, start, k, n, pre, res):
        if len(pre) == k:
            res.append(pre[:])
            return

        # 注意：这里 i 的上限是归纳得到的
        for i in range(start, n - (k - len(pre)) + 2):
            pre.append(i)
            self.__dfs(i + 1, k, n, pre, res)
            pre.pop()


if __name__ == '__main__':
    solution = Solution()
    n = 5
    k = 2
    res = solution.combine(n, k)
    print(res)
