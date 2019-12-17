from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        size = len(nums)
        if size == 0:
            return [-1, -1]

        lower_bound = self.__find_lower_bound(nums, size, target)
        if lower_bound == -1:
            return [-1, -1]
        up_bound = self.__find_up_bound(nums, size, target)
        return [lower_bound, up_bound]

    def __find_lower_bound(self, nums, size, target):
        left = 0
        right = size - 1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid
        return left if nums[left] == target else -1

    def __find_up_bound(self, nums, size, target):
        left = 0
        right = size - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if nums[mid] > target:
                right = mid - 1
            else:
                left = mid
        # 能走到这里，肯定是 lower_bound 里面找到了，所以不用后处理
        return left
