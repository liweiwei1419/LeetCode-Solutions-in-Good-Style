from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        if size < 1:
            return 0
        min_value = prices[0]
        max_profit = 0
        for i in range(1, size):
            max_profit = max(max_profit, prices[i] - min_value)
            # 其实就是在求最小值 dp[1][i] = max(dp[1][i - 1], - prices[i])
            min_value = min(min_value, prices[i])
        return max_profit


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]
    solution = Solution()
    result = solution.maxProfit(prices)
    print(result)
