from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        tmp = []
        # momo = [[False for _ in range(n)] for _ in range(m)]
        momo = []
        count = 0
        for i in range(m):
            for w in range(n):
                if grid[i][w] == "1" and not momo[i][w]:
                    count += 1
                    tmp.append((i, w))
                    momo[i][w] = True
                while tmp:
                    x, y = tmp.pop(0)
                    for tmp_x, tmp_y in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                        xx = x + tmp_x
                        yy = y + tmp_y
                        if 0 <= xx < m and 0 <= yy < n and grid[xx][yy] == "1" and not momo[xx][yy]:
                            tmp.append((xx, yy))
                            momo[xx][yy] = True

        return count
