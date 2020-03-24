from typing import List


class Solution:

    # 按照区间的右侧端点升序排序

    def findMinArrowShots(self, points: List[List[int]]) -> int:
        size = len(points)
        if size < 2:
            return size

        # 原地排序，按照区间的右端点进行升序排序
        points.sort(key=lambda x: x[1])
        res = 1
        end = points[0][1]
        for i in range(1, size):
            if points[i][0] > end:
                end = points[i][1]
                res += 1
        return res


if __name__ == '__main__':
    points = [[10, 16], [2, 8], [1, 6], [7, 12]]

    s = Solution()

    result = s.findMinArrowShots(points)
    print(result)
