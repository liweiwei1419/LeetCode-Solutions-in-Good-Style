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


# Python 伪代码1：当分支逻辑不能排除右边界时，选左中位数，如果选右中位数，会出现死循环。
def binary_search_1(l, r):
    while l < r:
        # 如果选择右中位数，当区间只剩下 2 个元素的时候，
        # 一旦进入 r = mid 这个分支，右边界不会收缩，代码进入死循环
        mid = l + (r - l) // 2
        if check(mid):
            # 先写可以排除中位数的逻辑
            l = mid + 1
        else:
            # 右边界不能排除
            r = mid
    # 退出循环的时候，视情况，是否需要单独判断 l （或者 r）这个索引表示的元素是否符合题意


# Python 伪代码2：当分支逻辑不能排除左边界时，选右中位数，因为如果你选左中位数，会出现死循环。
def binary_search_2(l, r):
    # 如果选择做中位数，当区间只剩下 2 个元素的时候，
    # 一旦进入 l = mid 这个分支，左边界不会收缩，代码进入死循环
    while l < r:
        mid = l + (r - l + 1) // 2
        if check(mid):
            # 先写可以排除中位数的逻辑
            r = mid - 1
        else:
            # 左边界不能排除
            l = mid
    # 退出循环的时候，视情况，是否需要单独判断 l （或者 r）这个索引表示的元素是否符合题意
