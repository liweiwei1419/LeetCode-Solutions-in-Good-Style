class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num < 2:
            return True

        left = 1
        right = num / 2
        while left <= right:
            mid = left + (right - left) // 2
            if num % mid == 0 and num // mid == mid:
                return True
            elif num // mid > mid:
                left = mid + 1
            else:
                right = mid - 1
        return False
