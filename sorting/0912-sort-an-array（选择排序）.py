from typing import List


class Solution:

    def sortArray(self, nums: List[int]) -> List[int]:
        size = len(nums)

        for i in range(size - 1):
            min_index = i
            for j in range(i + 1, size):
                if nums[j] < nums[min_index]:
                    min_index = j
            nums[i], nums[min_index] = nums[min_index], nums[i]
        return nums
