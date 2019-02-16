class Solution(object):

    def __factorial(self, n):
        res = 1
        while n > 1:
            res *= n
            n -= 1
        return res

    def __combination(self, m, n):
        """
        从 n 个物品里选出 m 个物品的组合数
        :param m:
        :param n:
        :return:
        """
        return self.__factorial(n) // (self.__factorial(m) * self.__factorial(n - m))

    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        return self.__combination(m - 1, m + n - 2)


if __name__ == '__main__':
    m = 7
    n = 3
    solution = Solution()
    result = solution.uniquePaths(m, n)
    print(result)
