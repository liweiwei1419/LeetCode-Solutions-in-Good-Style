from typing import List

class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        size = len(prices)

        if size < 2:
            return 0

        # dp[j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益
        # j = 0 表示不持股，j = 1 表示持股
        # 并且规定在买入股票的时候，扣除手续费

        dp = [0, 0]
        dp[0] = 0
        dp[1] = -prices[0] - fee

        for i in range(1, size):
            dp[0] = max(dp[0], dp[1] + prices[i])
            dp[1] = max(dp[1], dp[0] - prices[i] - fee)
        return dp[0]