from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        size = len(nums)
        left = 0
        right = size
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid

        return left
