from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        for j in range(1, cols):
            grid[0][j] = grid[0][j] + grid[0][j - 1]
        for i in range(1, rows):
            for j in range(cols):
                if j == 0:
                    grid[i][j] = grid[i][j] + grid[i - 1][j]
                else:
                    grid[i][j] = min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1])
        return grid[rows - 1][cols - 1]


if __name__ == '__main__':
    grid = [[1, 3, 1],
            [1, 5, 1],
            [4, 2, 1]]

    s = Solution()
    res = s.minPathSum(grid)
    print(res)
