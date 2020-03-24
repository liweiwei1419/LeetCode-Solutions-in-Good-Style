from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        size = len(nums)
        if size == 0:
            return [-1, -1]

        first_position = self.__find_first_position(nums, size, target)
        if first_position == -1:
            return [-1, -1]
        last_position = self.__find_last_position(nums, size, target)
        return [first_position, last_position]

    def __find_first_position(self, nums, size, target):
        left = 0
        right = size - 1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid

        if nums[left] == target:
            return left
        else:
            return -1

    def __find_last_position(self, nums, size, target):
        left = 0
        right = size - 1
        while left < right:
            mid = (left + right + 1) >> 1
            if nums[mid] > target:
                right = mid - 1
            else:
                left = mid

        # 由于能走到这里，说明在数组中一定找得到目标元素
        # 因此这里不用再做一次判断
        return left
