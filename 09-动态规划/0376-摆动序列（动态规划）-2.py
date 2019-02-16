class Solution:
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums)
        if size == 0:
            return 0
        up = 1
        down = 1
        for i in range(1, size):
            if nums[i - 1] < nums[i]:
                down = up + 1
            elif nums[i - 1] > nums[i]:
                up = down + 1
        return max(up, down)
