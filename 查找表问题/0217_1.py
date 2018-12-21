class Solution:
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        if len(nums) < 2:
            return False
        # 原地排序
        nums.sort()
        for index in range(1, len(nums)):
            if nums[index] == nums[index - 1]:
                return True
        return False
