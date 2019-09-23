from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        if size == 0:
            return 0
        max_profit = 0
        for i in range(1, size):
            if prices[i] - prices[i - 1] > 0:
                max_profit += (prices[i] - prices[i - 1])
        return max_profit


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]
    solution = Solution()
    result = solution.maxProfit(prices)
    print(result)
