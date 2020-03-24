from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)
        self.__quick_sort(nums, 0, size - 1)
        return nums

    def __quick_sort(self, nums, left, right):
        if left >= right:
            return
        p_index = self.__partition(nums, left, right)
        self.__quick_sort(nums, left, p_index - 1)
        self.__quick_sort(nums, p_index + 1, right)

    def __partition(self, nums, left, right):
        pivot = nums[left]
        # [left + 1, lt] < pivot
        # [lt + 1, i) >= pivot

        lt = left
        for i in range(left + 1, right + 1):
            if nums[i] < pivot:
                lt += 1
                nums[lt], nums[i] = nums[i], nums[lt]
        nums[lt], nums[left] = nums[left], nums[lt]
        return lt
