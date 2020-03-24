from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        size = len(cost)
        dp = [0 for _ in range(size)]

        dp[0] = cost[0]
        dp[1] = cost[1]

        for i in range(2, size):
            dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i]

        return min(dp[size - 1], dp[size - 2])
