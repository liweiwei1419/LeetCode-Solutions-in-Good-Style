class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 0:
            return 0
        min_val = prices[0]
        max_profit = 0
        for i in range(1, len(prices)):
            min_val = min(min_val, prices[i])
            max_profit = max(max_profit, prices[i]-min_val)
        return max_profit


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]
    solution = Solution()
    result = solution.maxProfit(prices)
    print(result)
