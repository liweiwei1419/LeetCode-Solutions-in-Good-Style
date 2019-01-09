class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m == 0:
            return 0
        dp = [1] * n
        for row in range(m - 1):
            for col in range(1, n):
                dp[col] += dp[col-1]
        return dp[-1]


if __name__ == '__main__':
    m = 3
    n = 4
    solution = Solution()
    result = solution.uniquePaths(m, n)
    print(result)
