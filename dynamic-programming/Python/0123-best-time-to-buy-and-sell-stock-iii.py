from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        size = len(prices)
        if size < 2:
            return 0

        # [0, left] 区间里进行一次买卖的最大收益
        left = [0 for _ in range(size)]
        min_val = prices[0]

        for i in range(1, size):
            left[i] = max(left[i - 1], prices[i] - min_val)
            min_val = min(min_val, prices[i])

        # [right, len - 1] 区间里进行一次买卖的最大收益
        right = [0 for _ in range(size)]
        max_val = prices[size - 1]

        for i in range(size - 2, -1, -1):
            right[i] = max(right[i + 1], max_val - prices[i])
            max_val = max(max_val, prices[i])

        # 枚举间隙
        # [0, 1[, 2, 3,] 4, 5]
        #  这里有一个坑，有可能是只交易一次的场景
        res = max(left[size - 1], right[0])
        for i in range(1, size - 2):
            res = max(res, left[i] + right[i + 1])
        return res
