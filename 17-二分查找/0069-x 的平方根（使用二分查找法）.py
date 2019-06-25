class Solution:
    # 二分法
    def mySqrt1(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x == 1:
            return 1
        l = 0
        r = x // 2
        while l <= r:
            m = l + (r - l) // 2
            s = m * m
            if s == x:
                return m
            elif s < x:
                l = m + 1
            else:
                r = m - 1
        return r

    # 二分法
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        # 为了照顾到 0 把左边界设置为 0
        l = 0
        # 为了照顾到 1 把右边界设置为 x // 2 + 1
        r = x // 2 + 1
        while l <= r:
            m = l + (r - l) // 2
            s = m * m
            if s == x:
                return m
            elif s < x:
                l = m + 1
            else:
                r = m - 1
        # 注意返回 l 和返回 r 的区别，应该返回 r
        # 【因为返回的是不超过，所要把右边界返回回去】
        return r


if __name__ == '__main__':
    x = 8
    solution = Solution()
    result = solution.mySqrt(x)
    print(result)
