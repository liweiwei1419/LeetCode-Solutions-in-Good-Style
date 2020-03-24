from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        size = len(nums)
        if size == 0:
            raise ValueError("传入无效的参数")
        if size == 1:
            return nums[0]
        return self.__find_min(nums, 0, size - 1)

    def __find_min(self, nums, left, right):
        if left == right:
            return nums[left]
        if left + 1 == right:
            return min(nums[left], nums[right])
        mid = (left + right) >> 1

        if nums[mid] < nums[right]:
            return min(self.__find_min(nums, left, mid - 1), nums[mid])
        else:
            # nums[mid] > nums[right]
            # [4,5,6,7,8,1,2]
            return min(nums[left], self.__find_min(nums, mid + 1, right))
