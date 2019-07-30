class Solution:
    def integerBreak(self, n):
        dp = [1 for _ in range(n + 1)]
        for i in range(2, n + 1):
            for j in range(1, i):
                dp[i] = max(dp[i], j * dp[i - j], j * (i - j))
        return dp[n]


if __name__ == '__main__':
    n = 10
    s = Solution()
    res = s.integerBreak(n)
    print(res)
