from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        size = len(nums)
        # 特判
        if size < 2:
            return False

        # 原地排序，这一步是关键
        nums.sort()
        for i in range(1, size):
            if nums[i] == nums[i - 1]:
                return True
        return False
