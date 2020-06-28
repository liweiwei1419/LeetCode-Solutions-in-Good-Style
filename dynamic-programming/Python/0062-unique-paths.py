class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n)] for _ in range(m)]
        dp[0][0] = 1

        for i in range(m):
            for j in range(n):
                if i == 0:
                    if j == 0:
                        continue
                    dp[0][j] = dp[0][j - 1]
                elif j == 0:

                    dp[i][0] = dp[i - 1][0]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[- 1][- 1]


if __name__ == '__main__':
    s = Solution()
    res = s.uniquePaths(7, 3)
    print(res)