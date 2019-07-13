# 分别统计 0、1、2 出现的次数，然后再对数组重新赋值
# 桶排序

from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        counter = [0] * 3
        for num in nums:
            counter[num] += 1
        i = 0
        for idx, count in enumerate(counter):
            for _ in range(count):
                nums[i] = idx
                i += 1


if __name__ == '__main__':
    nums = [0, 1, 2, 0, 1, 2, 1, 1, 1, 2, 2, 2]
    solution = Solution()
    solution.sortColors(nums)
    print(nums)
