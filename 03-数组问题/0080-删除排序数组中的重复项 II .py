class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = len(nums)
        if l <= 2:
            return l
        counter = 2
        for i in range(2, l):
            if nums[i] != nums[counter - 2]:
                nums[counter] = nums[i]
                counter += 1
        return counter
