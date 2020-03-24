from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        size = len(triangle)
        if size == 0:
            return 0
        dp = [0] * size
        for i in range(size):
            dp[i] = triangle[size - 1][i]
        for i in range(size - 2, - 1, -1):
            for j in range(i + 1):
                dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j]
        return dp[0]
