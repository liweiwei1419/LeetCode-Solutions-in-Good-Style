from typing import List

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        size = len(prices)
        if k == 0 or size < 2:
            return 0
        if k > size // 2:
            max_profit = 0
            for i in range(1, size):
                if prices[i] > prices[i - 1]:
                    max_profit += prices[i] - prices[i - 1]
            return max_profit

        cash = [0 for _ in range(k)]

        stock = [float('-inf') for _ in range(k)]
        for price in prices:

            stock[0] = max(stock[0], -price) # 持股
            cash[0] = max(cash[0], stock[0] + price) # 持现金
            for i in range(1, k):
                stock[i] = max(stock[i], cash[i - 1] - price)
                cash[i] = max(cash[i], stock[i] + price)
        return cash[-1]
