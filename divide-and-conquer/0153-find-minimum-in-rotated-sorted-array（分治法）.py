
from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        size = len(nums)
        if size == 0:
            raise Exception('程序出错')
        if size == 1:
            return nums[0]
        return self.__findMin(nums, 0, size - 1)

    def __findMin(self, nums, left, right):
        if left == right:
            return nums[left]
        if left + 1 == right:
            return min(nums[left], nums[right])
        # mid = left + (right - left) // 2
        mid = (left + right) >> 1
        return min(self.__findMin(nums, left, mid),
                   self.__findMin(nums, mid + 1, right))
