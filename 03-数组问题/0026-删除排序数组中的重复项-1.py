class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0

        pre_num = nums[0]

        # 为什么可以从 1 开始呢，因为只要这个数组有元素，就一定会有 1 个元素被保留下来
        j = 1
        for i in range(1, len(nums)):
            if nums[i] == pre_num:
                # 如果和之前的元素相等，就继续遍历下一个
                continue
            else:
                # 如果不一样
                # 更新 pre_num，覆盖元素，标记 + 1
                pre_num = nums[i]
                nums[j] = nums[i]
                j += 1

        for i in range(len(nums) - j):
            nums.pop()

        return j
