class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums)
        # 只要有重复的元素覆盖就可以了
        if size == 0:
            return 0
        # 接下来要赋值的那个元素
        next = 0
        for index in range(1, size):
            if nums[index] != nums[next]:
                next += 1
                nums[next] = nums[index]
        # 当前在最后一个位置上，+ 1 才是新数组的长度
        return next + 1
