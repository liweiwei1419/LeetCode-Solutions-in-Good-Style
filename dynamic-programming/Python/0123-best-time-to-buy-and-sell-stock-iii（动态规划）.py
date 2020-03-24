from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        if size < 2:
            return 0

        unassign_val = -9999

        dp = [[unassign_val for _ in range(5)] for _ in range(size)]
        dp[0][0] = 0
        dp[0][1] = -prices[0]

        # // dp[i][j] ，i 表示 [0, i] 区间里，状态为 j 的最大收益
        # j = 0：什么都不操作
        # j = 1：第 1 次买入一支股票
        # j = 2：第 1 次卖出一支股票
        # j = 3：第 2 次买入一支股票
        # j = 4：第 2 次卖出一支股票

        for i in range(1, size):
            dp[i][0] = 0
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
            dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i])

            if dp[i - 1][2] != unassign_val:
                dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i])

            if dp[i - 1][3] != unassign_val:
                dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i])

        return max(0, dp[-1][2], dp[-1][4])
