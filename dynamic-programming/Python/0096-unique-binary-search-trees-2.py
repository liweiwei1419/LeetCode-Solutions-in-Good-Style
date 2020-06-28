class Solution:
    def numTrees(self, n: int) -> int:
        # 因为需要 0 ，所以多开 1 个空间
        dp = [0 for _ in range(n + 1)]
        dp[0] = 1
        dp[1] = 1

        for i in range(2, n + 1):
            for j in range(i):
                dp[i] += dp[j] * dp[i - j - 1]

        return dp[n]


if __name__ == '__main__':
    solution = Solution()
    n = 3
    result = solution.numTrees(n)
    print(result)
