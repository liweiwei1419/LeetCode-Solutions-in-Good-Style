class Solution:
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """

        length = len(points)

        if length == 0:
            return 0

        # 原地排序，按照区间的左端点进行升序排序
        points.sort(key=lambda x: x[0])

        end = points[0][1]
        res = 1
        for point in points[1:]:
            if point[0] <= end:
                # 不用浪费箭
                end = min(end, point[1])
            else:
                assert point[0] > end
                res += 1
                end = point[1]
        return res


if __name__ == '__main__':
    points = [[10, 16], [2, 8], [1, 6], [7, 12]]
    s = Solution()
    result = s.findMinArrowShots(points)
    print(result)
