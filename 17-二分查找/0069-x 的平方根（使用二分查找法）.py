class Solution:

    # 二分法
    def mySqrt(self, x: int) -> int:
        if x == 1:
            return 1
        left = 0
        right = x // 2
        while left <= right:
            mid = left + (right - left) // 2
            square = mid * mid
            if square == x:
                return mid
            elif square < x:
                left = mid + 1
            else:
                right = mid - 1
        return right

    # 二分法
    def mySqrt(self, x: int) -> int:
        # 为了照顾到 0 把左边界设置为 0
        left = 0
        # 为了照顾到 1 把右边界设置为 x // 2 + 1
        right = x // 2 + 1
        while left <= right:
            # mid = left + (right - left) // 2
            mid = (left + right) >> 1
            square = mid * mid
            if square == x:
                return mid
            elif square < x:
                left = mid + 1
            else:
                right = mid - 1
        # 注意返回 left 和返回 right 的区别，应该返回 right
        # 【因为返回的是不超过，所要把右边界返回回去】
        return right


if __name__ == '__main__':
    x = 8
    solution = Solution()
    result = solution.mySqrt(x)
    print(result)


# Python 伪代码1：当分支逻辑不能排除右边界时，选左中位数，如果选右中位数，会出现死循环。
def binary_search_1(left, right):
    # 如果选择右中位数，当区间只剩下 2 个元素的时候，
    # 一旦进入 right = mid 这个分支，右边界不会收缩，代码进入死循环
    while left < right:
        # 选择左中位数
        # mid = left + (right - left) // 2
        # left 和 right 一般都表示索引，使用 + 且无符号右移，在 left 和 right 都很大的时候，虽然整形溢出，但结果正确
        # 在 Java 中使用 `int mid = (left + right) >>> 1;` ，一定是无符号右移
        mid = (left + right) >> 1
        if check(mid):
            # 先写可以排除中位数的逻辑
            left = mid + 1
        else:
            # 右边界不能排除，这半边逻辑不用记
            # 逻辑是：上一个分支的另一个边界收缩，但不排除中位数
            right = mid
    # 退出循环的时候，视情况，是否需要单独判断 left （或者 right）这个索引表示的元素是否符合题意


# Python 伪代码2：当分支逻辑不能排除左边界时，选右中位数，因为如果你选左中位数，会出现死循环。
def binary_search_2(left, right):
    # 如果选择左中位数，当区间只剩下 2 个元素的时候，
    # 一旦进入 left = mid 这个分支，左边界不会收缩，代码进入死循环
    while left < right:
        # 选择右中位数
        # mid = left + (right - left + 1) // 2
        # left 和 right 一般都表示索引，使用 + 且无符号右移，在 left 和 right 都很大的时候，虽然整形溢出，但结果正确
        # 在 Java 中使用 `int mid = (left + right + 1) >>> 1;` ，一定是无符号右移
        mid = (left + right + 1) >> 1
        if check(mid):
            # 先写可以排除中位数的逻辑
            right = mid - 1
        else:
            # 左边界不能排除，这半边逻辑不用记
            # 逻辑是：上一个分支的另一个边界收缩，但不排除中位数
            left = mid
    # 退出循环的时候，视情况，是否需要单独判断 left （或者 right）这个索引表示的元素是否符合题意
