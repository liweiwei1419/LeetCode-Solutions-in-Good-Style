from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:

        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])

        for col in range(1, n):
            # 第 0 行特殊处理，不要忘记了
            grid[0][col] += grid[0][col - 1]
        for row in range(1, m):
            grid[row][0] += grid[row - 1][0]
            for col in range(1, n):
                grid[row][col] += min(grid[row - 1][col], grid[row][col - 1])
        return grid[-1][-1]


if __name__ == '__main__':
    grid = [[1, 3, 1],
            [1, 5, 1],
            [4, 2, 1]]

    s = Solution()
    res = s.minPathSum(grid)
    print(res)
