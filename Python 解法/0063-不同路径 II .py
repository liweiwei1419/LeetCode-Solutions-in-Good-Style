# 63. 不同路径 II
# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
#
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
#
# 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
class Solution(object):
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

        dp = [0] * n
        # 这一步不要忘记了
        dp[0] = 1
        # 再写后面几行
        for row in range(m):
            for col in range(n):
                # 【就分下面这两种情况就可以了】
                if obstacleGrid[row][col] == 1:
                    dp[col] = 0
                elif col > 0:
                    dp[col] += dp[col - 1]
                else:
                    # 第 0 列不是 0 就是 1
                    # 0 的情况首先判断了
                    # 什么都不做
                    pass
        return dp[-1]
