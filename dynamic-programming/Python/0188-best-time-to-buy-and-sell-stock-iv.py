from typing import List


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        size = len(prices)
        if size < 2 or k == 0:
            return 0
        if k >= size // 2:
            res = 0
            for i in range(1, size):
                if prices[i] > prices[i - 1]:
                    res += (prices[i] - prices[i - 1])
            return res

        dp = [[[0, -9999] for _ in range(k + 1)] for _ in range(size + 1)]

        # 注意：i 和 j 都有 1 个位置的偏移
        for i in range(1, size + 1):
            for j in range(1, k + 1):
                dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1])
                dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1])

        return dp[size][k][0]
