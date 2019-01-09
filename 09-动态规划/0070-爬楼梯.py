# @Time    : 18/3/21 下午9:56
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com


class Solution:
    memo = None

    def _climbStairs(self, n):
        if Solution.memo[n] != -1:
            return Solution.memo[n]

        if n == 0:
            return 1
        if n == 1:
            return 1
        Solution.memo[n] = self._climbStairs(n - 1) + self._climbStairs(n - 2)
        return Solution.memo[n]

    def climbStairs(self, n):
        Solution.memo = [-1] * (n + 1)
        return self._climbStairs(n)


if __name__ == '__main__':
    s = Solution()
    res = s.climbStairs(10)
    print(res)
