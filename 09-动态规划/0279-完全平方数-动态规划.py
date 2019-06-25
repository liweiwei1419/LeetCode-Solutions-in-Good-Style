class Solution:
    def numSquares(self, n: int) -> int:
        dp = [0 for _ in range(n + 1)]
        dp[1] = 1

        for i in range(2, n + 1):
            dp[i] = 9999
            for j in range(1, i):
                if i - j * j < 0:
                    break
                dp[i] = min(dp[i], 1 + dp[i - j * j])
        return dp[n]


if __name__ == '__main__':
    solution = Solution()
    n = 12
    result = solution.numSquares(n)
    print(result)
