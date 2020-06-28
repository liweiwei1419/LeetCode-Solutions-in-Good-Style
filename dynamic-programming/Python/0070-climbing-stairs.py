class Solution:
    def mySqrt(self, x: int) -> int:

        if x == 0:
            return 0

        left = 1
        right = x // 2

        while left < right:
            mid = (left + right + 1) >> 1

            if mid * mid < x:
                # 此时 mid 可能是解，mid 的右边也有可能是解，
                # mid 的左边一定不是解
                # 下一轮搜索的区间是 [mid, right]
                left = mid
            elif mid * mid == x:
                return mid
            else:
                # 此时 mid * mid > x
                # mid 一定不是解，mid 的右边也一定不是解
                # 下一轮搜索的区间是 [left, mid - 1]
                right = mid - 1

        return left
