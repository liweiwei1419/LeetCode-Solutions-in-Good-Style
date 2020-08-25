from typing import List


class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        rows = len(dungeon)
        cols = len(dungeon[0])

        dp = [[9999 for _ in range(cols + 1)] for _ in range(rows + 1)]

        dp[rows][cols - 1] = 1
        dp[rows - 1][cols] = 1
        for i in range(rows - 1, -1, -1):
            for j in range(cols - 1, -1, -1):
                min_val = min(dp[i + 1][j], dp[i][j + 1])
                dp[i][j] = max(min_val - dungeon[i][j], 1)
        return dp[0][0]
