class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        dp[1][0] = 1
        for i in range(m):
            for j in range(n):
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j]
        return dp[m][n]


if __name__ == '__main__':
    s = Solution()
    res = s.uniquePaths(7, 3)
    print(res)
