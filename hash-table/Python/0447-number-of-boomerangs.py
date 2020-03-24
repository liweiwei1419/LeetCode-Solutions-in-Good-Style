class Solution:
    def numberOfBoomerangs(self, points):
        import math
        res = 0
        size = len(points)
        d = dict()

        for i in range(size):
            for j in range(size):
                if i != j:

                    distance = math.pow(points[i][0] - points[j][0], 2) + math.pow(points[i][1] - points[j][1], 2)
                    if distance in d:
                        n = d[distance]
                        res += 2 * n
                        d[distance] = (n + 1)
                    else:
                        d[distance] = 1
            d.clear()
        return res


if __name__ == '__main__':
    points = [[0, 0], [1, 0], [2, 0]]
    solution = Solution()
    res = solution.numberOfBoomerangs(points)

    print(res)
