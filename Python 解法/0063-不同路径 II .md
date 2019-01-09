

https://leetcode.com/problems/unique-paths-ii/description/


Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

加了缓存的记忆化搜索的解法：
```python
class Solution:

    def __init__(self):
        self.cached = []
        self.obstacleGrid = None

    def _path_ways(self, i, j):
        if self.cached[i][j] != 0:
            return self.cached[i][j]
        if self.obstacleGrid[i][j] == 1:
            return 0
        if i == 0 and j == 0:
            return 1
        if i == 0:
            ways = self._path_ways(0, j - 1)
        elif j == 0:
            ways = self._path_ways(i - 1, 0)
        else:
            ways = self._path_ways(i, j - 1) + self._path_ways(i - 1, j)
        self.cached[i][j] = ways
        return ways

    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m = len(obstacleGrid)
        if m == 0:
            return 0
        n = len(obstacleGrid[0])
        self.cached = [[0 for _ in range(n)] for _ in range(m)]
        self.obstacleGrid = obstacleGrid
        return self._path_ways(m - 1, n - 1)
```


动态规划的解法：
```python
class Solution:

    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m = len(obstacleGrid)
        if m == 0:
            return 0
        n = len(obstacleGrid[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]

        if obstacleGrid[0][0] == 1:
            return 0
        else:
            dp[0][0] = 1

        for i in range(m):
            for j in range(n):
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0
                    continue
                if i == 0:
                    if j == 0:
                        continue
                    dp[0][j] = dp[0][j - 1]
                elif j == 0:
                    dp[i][0] = dp[i - 1][0]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]
```