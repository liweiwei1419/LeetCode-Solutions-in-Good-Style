from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], H: int) -> int:
        left = 1
        right = max(piles)

        while left < right:
            mid = (left + right) >> 1

            if self.__calculate_sum(piles, mid) > H:
                left = mid + 1
            else:
                right = mid
        return left

    def __calculate_sum(self, piles, speed):
        res = 0
        for pile in piles:
            res += (pile + speed - 1) // speed
        return res
