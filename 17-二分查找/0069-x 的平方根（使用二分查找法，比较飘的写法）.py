class Solution:

    # 二分法
    def mySqrt(self, x: int) -> int:
        left = 0
        right = 999999
        while left < right:
            mid = (left + right + 1) >> 1
            square = mid * mid
            if square > x:
                right = mid - 1
            else:
                left = mid

        return left
