from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # 桶排序，数字 i 应该在索引 i - 1 上，否则交换
        size = len(nums)
        for i in range(size):
            while nums[i] != i + 1:
                if nums[i] == nums[nums[i] - 1]:
                    return nums[i]
                self.__swap(nums, i, nums[i] - 1)

    def __swap(self, nums, index1, index2):
        nums[index1], nums[index2] = nums[index2], nums[index1]
