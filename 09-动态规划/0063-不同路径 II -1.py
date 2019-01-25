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

        if obstacleGrid[0][0] == 1:
            return 0
        dp_row = [0] * n
        dp_col = [0] * m
        # 找到第 1 个为 1 的数，将后面的值全部赋值成 0

        for i in range(n):
            if obstacleGrid[0][i] == 0:
                dp_row[i] = 1
                continue
            else:
                break
        for i in range(m):
            if obstacleGrid[i][0] == 0:
                dp_col[i] = 1
                continue
            else:
                break

        # 到这里就把第 0 行和第 0 列全部写出来了

        for i in range(1, m):
            dp_row[0] = dp_col[i]
            for j in range(1, n):
                if obstacleGrid[i][j] == 1:
                    dp_row[j] = 0
                else:
                    dp_row[j] = dp_row[j] + dp_row[j - 1]

        return dp_row[-1]


if __name__ == '__main__':

    obstacleGrid = [[0],[1]]
    # obstacleGrid = [[0, 0, 0], [0, 1, 0], [0, 0, 0]]
    # obstacleGrid = [[0, 1]]
    s = Solution()
    res = s.uniquePathsWithObstacles(obstacleGrid)
    print(res)
