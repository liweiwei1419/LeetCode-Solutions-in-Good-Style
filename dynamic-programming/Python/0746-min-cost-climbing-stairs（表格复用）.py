from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        size = len(cost)
        dp = [0, 0, 0]

        dp[0] = cost[0]
        dp[1] = cost[1]

        for i in range(2, size):
            dp[i % 3] = min(dp[(i - 1) % 3], dp[(i - 2) % 3]) + cost[i]

        return min(dp[(size - 1) % 3], dp[(size - 2) % 3])
