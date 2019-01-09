class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 只要有重复的元素覆盖就可以了
        if len(nums) == 0:
            return 0
        j = 0  # 接下来要赋值的那个元素
        for i in range(1, len(nums)):
            if nums[i] != nums[j]:
                j += 1
                nums[j] = nums[i]
        return j + 1
