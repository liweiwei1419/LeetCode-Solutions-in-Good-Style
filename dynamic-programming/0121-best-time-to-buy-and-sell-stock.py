from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        if size < 1:
            return 0
        min_val = prices[0]
        max_profit = 0
        for i in range(1, size):
            min_val = min(min_val, prices[i])
            max_profit = max(max_profit, prices[i] - min_val)
        return max_profit


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]
    solution = Solution()
    result = solution.maxProfit(prices)
    print(result)
