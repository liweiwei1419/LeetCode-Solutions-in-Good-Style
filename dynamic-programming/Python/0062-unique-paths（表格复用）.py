class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1] * n
        for i in range(1, m):
            # 从下标 2 开始走就行了
            for j in range(1, n):
                dp[j] = dp[j] + dp[j - 1]
        return dp[-1]


if __name__ == '__main__':
    m = 3
    n = 4
    solution = Solution()
    result = solution.uniquePaths(m, n)
    print(result)
