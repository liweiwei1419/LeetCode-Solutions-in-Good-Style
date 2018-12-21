class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        map = dict()
        for index, num in enumerate(nums):
            if target - num in map:
                return [index, map[target - num]]
            else:
                map[num] = index
