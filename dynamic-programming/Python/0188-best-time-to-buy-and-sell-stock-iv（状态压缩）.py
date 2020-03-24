from typing import List


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        """
        :rtype: object
        """
        size = len(prices)

        if size < 2 or k == 0:
            return 0

        if k >= size // 2:
            res = 0
            for i in range(1, size):
                if prices[i] > prices[i - 1]:
                    res += (prices[i] - prices[i - 1])
            return res

        dp = [[0, -9999] for _ in range(k + 1)]

        for i in range(size):
            # 注意：这里要从 1 开始
            for j in range(k, 0, -1):
                # 这两行可以交换，先买后卖，所以先写 1 ，再写 0
                dp[j][1] = max(dp[j][1], dp[j - 1][0] - prices[i])
                dp[j][0] = max(dp[j][0], dp[j][1] + prices[i])

        return dp[k][0]