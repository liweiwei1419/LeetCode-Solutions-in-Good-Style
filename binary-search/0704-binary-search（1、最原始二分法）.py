from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        size = len(nums)
        if size == 0:
            return -1

        left = 0
        right = size - 1
        while left <= right:
            mid = (left + right) >> 1
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                # [1, 2, 3, 4, 5, 6, 7, 8]
                right = mid - 1
            else:
                left = mid + 1
        return -1
