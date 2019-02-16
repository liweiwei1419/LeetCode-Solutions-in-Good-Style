class Solution:

    def __init__(self):
        self.triangle = None
        self.memo = []

    def __pass_way(self, i, j):
        """
        :param i: 表示第几层
        :param j: 表示第几个索引，j<=i
        :return:
        """
        if i == 0:
            return self.triangle[0][0]
        # 如果有缓存，就读缓存的内容
        if self.memo[i][j] is not None:
            return self.memo[i][j]

        res = float("inf")
        # 最左边的点，
        if j == 0:
            res = min(res, self.triangle[i][j] + self.__pass_way(i - 1, 0))
        elif j == i:
            res = min(res, self.triangle[i][j] + self.__pass_way(i - 1, j - 1))
        else:
            res = min(res, self.triangle[i][j] + self.__pass_way(i - 1, j - 1),
                      self.triangle[i][j] + self.__pass_way(i - 1, j))
        self.memo[i][j] = res
        return self.memo[i][j]

    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        self.triangle = triangle
        res = float("inf")
        n = len(self.triangle)
        for i in range(1, n + 1):
            self.memo.append([None] * i)
        for i in range(n):
            res = min(res, self.__pass_way(n - 1, i))
        return res


if __name__ == '__main__':
    triangle = [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]
    s = Solution()
    res = s.minimumTotal(triangle)
    print(res)
