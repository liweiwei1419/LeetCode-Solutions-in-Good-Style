from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        size = len(nums)
        if size < 2:
            return size

        # 循环不变量：[0, j] 是删除重复元素以后得到的新数组
        j = 0
        for i in range(1, size):
            if nums[i] != nums[j]:
                j += 1
                nums[j] = nums[i]
        return j + 1
