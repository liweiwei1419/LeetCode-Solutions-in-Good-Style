# 200. 岛屿的个数
# 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
# 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
# 你可以假设网格的四个边均被水包围。

# 说明：这道题还可以使用回溯的方法。
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """