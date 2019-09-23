from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        if size < 1:
            return 0

        dp = [[None for _ in range(size)] for _ in range(2)]

        dp[0][0] = 0
        dp[1][0] = -prices[0]

        for i in range(1, size):
            dp[0][i] = max(dp[0][i - 1], dp[1][i - 1] + prices[i])
            dp[1][i] = max(dp[1][i - 1], - prices[i])
        # print(dp)
        return dp[0][size - 1]


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]
    solution = Solution()
    result = solution.maxProfit(prices)
    print(result)
