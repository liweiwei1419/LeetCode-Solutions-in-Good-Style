from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        size = len(nums)
        if size <= 2:
            return size
        # counter 表示下一个要覆盖的下标
        counter = 2
        # 下标为 0 和 1 的数一定会被保留，因此遍历从下标 2 开始
        for i in range(2, size):
            if nums[i] != nums[counter - 2]:
                nums[counter] = nums[i]
                counter += 1
        return counter