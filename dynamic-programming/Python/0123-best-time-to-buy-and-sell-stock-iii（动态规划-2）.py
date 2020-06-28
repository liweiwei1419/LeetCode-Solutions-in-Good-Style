from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        if size < 2:
            return 0

        dp = [0 for _ in range(5)]
        dp[0] = 0
        dp[1] = -prices[0]

        dp[3] = float('-inf')

        # dp[j]：i 表示 [0, i] 区间里，状态为 j 的最大收益
        # j = 0：什么都不操作
        # j = 1：第 1 次买入一支股票
        # j = 2：第 1 次卖出一支股票
        # j = 3：第 2 次买入一支股票
        # j = 4：第 2 次卖出一支股票

        for i in range(1, size):
            dp[0] = 0
            dp[1] = max(dp[1], - prices[i])
            dp[2] = max(dp[2], dp[1] + prices[i])
            dp[3] = max(dp[3], dp[2] - prices[i])
            dp[4] = max(dp[4], dp[3] + prices[i])
        return max(0, dp[2], dp[4])
