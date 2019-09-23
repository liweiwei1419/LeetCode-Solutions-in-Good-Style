from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash = dict()
        for index, num in enumerate(nums):
            if target - num in hash:
                return [index, hash[target - num]]
            else:
                hash[num] = index
