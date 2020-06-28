# 第695题
class Solution:

    def __init__(self):
        self.directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        self.cols = 0
        self.rows = 0
        self.grid = None
        self.visited = None

    def maxAreaOfIsland(self, grid) -> int:
        self.grid = grid

        self.rows = len(grid)
        if self.rows == 0:
            return 0

        self.cols = len(grid[0])
        if self.cols == 0:
            return 0

        self.visited = [[False for _ in range(self.cols)] for _ in range(self.rows)]

        res = 0
        for i in range(self.rows):
            for j in range(self.cols):
                # 在递归中计算岛屿的面积
                res = max(res, self.__dfs(i, j))

        return res

    def __dfs(self, i, j):
        step = 0
        if self.__in_area(i, j) and not self.visited[i][j] and self.grid[i][j] == 1:
            step += 1
            self.visited[i][j] = True
            for direction in self.directions:
                new_x = i + direction[0]
                new_y = j + direction[1]
                step += self.__dfs(new_x, new_y)
        return step

    def __in_area(self, i, j):
        return 0 <= i < self.rows and 0 <= j < self.cols


if __name__ == '__main__':
    grid = [[1, 1, 0, 0, 0],
            [1, 1, 0, 0, 0],
            [0, 0, 0, 1, 1],
            [0, 0, 0, 1, 1]]
    solution = Solution()
    res = solution.maxAreaOfIsland(grid)
    print(res)
