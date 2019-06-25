class Solution:
    def mySqrt(self, x: int) -> int:

        if x == 0:
            return 0

        l = 1
        r = x // 2

        while l < r:
            mid = l + (r - l + 1) // 2
            square = mid * mid

            if square > x:
                r = mid - 1
            else:
                l = mid
        return l


