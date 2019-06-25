class Solution:
    def numSquares(self, n: int) -> int:
        dp = [0 for _ in range(n + 1)]
        dp[1] = 1

        for j in range(2, n + 1):
            dp[j] = 1 + min([dp[j - i ** 2] for i in range(1, int(j ** 0.5) + 1)])

        return dp[n]


if __name__ == '__main__':
    solution = Solution()
    n = 12
    result = solution.numSquares(n)
    print(result)
