from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        size = len(nums)
        if size < 3:
            return size

        j = 2
        for i in range(2, size):
            if nums[i] != nums[j - 2]:
                nums[j] = nums[i]
                j += 1
        return j
