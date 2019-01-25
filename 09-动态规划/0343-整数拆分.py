class Solution:
    def integerBreak(self, n):
        """
        :type n: int
        :rtype: int
        """
        product = [0] * (n + 1)
        product[1] = 1
        for i in range(2, n + 1):
            product_max = 0
            for j in range(1, i):
                product_max = max(j * product[i - j], product_max, j * (i - j))
            product[i] = product_max
        return product[n]


if __name__ == '__main__':
    n = 10
    s = Solution()
    res = s.integerBreak(n)
    print(res)
