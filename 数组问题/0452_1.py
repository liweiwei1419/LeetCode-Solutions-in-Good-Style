class Solution:
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        if len(points) < 2:
            return len(points)
        # 按照区间的左侧端点进行升序排序
        points = sorted(points, key=lambda x: x[0])
        min_arrow_shots = 1
        end = points[0][1]
        for point in points[1:]:
            if point[0] <= end:
                end = min(end, point[1])
            else:
                min_arrow_shots += 1
                end = point[1]
        return min_arrow_shots


if __name__ == '__main__':
    points = [[10, 16], [2, 8], [1, 6], [7, 12]]

    s = Solution()

    result = s.findMinArrowShots(points)
    print(result)
